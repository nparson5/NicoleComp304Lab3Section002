package nicole.parsons.s300941374.ui.nicole
//Nicole Parsons - 300941374 - Section 002
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import androidx.core.content.res.ResourcesCompat
import nicole.parsons.s300941374.R


class NicoleCanvasView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0
    ) : View(context, attrs, defStyle) {

    private val black = ResourcesCompat.getColor(resources, R.color.black, null)

    //player can update
    var penWidth = 12f//default pen width
    var penColour = black//default pen width

    private var path = Path()//what the user is drawing


    private val transparent = ResourcesCompat.getColor(resources, R.color.transparent, null)
    private lateinit var extraCanvas: Canvas
    private lateinit var extraBitmap: Bitmap


    //everything about the brush
    val paint = Paint().apply {
        color = penColour
        isAntiAlias = true
        isDither = true
        style = Paint.Style.STROKE
        strokeJoin = Paint.Join.ROUND
        strokeCap = Paint.Cap.ROUND
        strokeWidth = penWidth
    }

        private val touchTolerance = ViewConfiguration.get(context).scaledTouchSlop//to avoid drawing extra unecessary pixels

        private var currentX = 0f
        private var currentY = 0f

        private var motionTouchEventX = 0f
        private var motionTouchEventY = 0f

        //basically on create (called after inflate)
        override fun onSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {
            super.onSizeChanged(width, height, oldWidth, oldHeight)

            if (::extraBitmap.isInitialized) extraBitmap.recycle()
            extraBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            extraCanvas = Canvas(extraBitmap)
            extraCanvas.drawColor(transparent)

        }

        override fun onDraw(canvas: Canvas) {
            // draw path
            canvas.drawBitmap(extraBitmap, 0f, 0f, null)

        }


        override fun onTouchEvent(event: MotionEvent): Boolean {
            motionTouchEventX = event.x
            motionTouchEventY = event.y

            when (event.action) {
                MotionEvent.ACTION_DOWN -> touchStart()
                MotionEvent.ACTION_MOVE -> touchMove()
                MotionEvent.ACTION_UP -> touchUp()
            }
            return true
        }

        //start when user starts drawing
        private fun touchStart() {
            path.reset()
            path.moveTo(motionTouchEventX, motionTouchEventY)
            currentX = motionTouchEventX
            currentY = motionTouchEventY
        }

        private fun touchMove() {
            val dx = Math.abs(motionTouchEventX - currentX)
            val dy = Math.abs(motionTouchEventY - currentY)
            if (dx >= touchTolerance || dy >= touchTolerance) {

                path.quadTo(
                    currentX,
                    currentY,
                    (motionTouchEventX + currentX) / 2,
                    (motionTouchEventY + currentY) / 2
                )
                currentX = motionTouchEventX
                currentY = motionTouchEventY
                extraCanvas.drawPath(path, paint)
            }

            invalidate()
        }

    private fun touchUp() {
        // Reset path
        path.reset()
    }

    fun updatePen() {
        paint.color = penColour
        paint.strokeWidth = penWidth
    }


}
