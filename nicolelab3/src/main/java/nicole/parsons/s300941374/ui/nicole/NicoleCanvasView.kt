package nicole.parsons.s300941374.ui.nicole

import android.content.Context
import android.graphics.*
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
    ) : View(context, attrs, defStyle)

    {

        private  val STROKE_WIDTH = 12f

        private var path = Path()//what the user is drawing

        private val drawColor = ResourcesCompat.getColor(resources, R.color.colorPaint, null)
        private val backgroundColor = ResourcesCompat.getColor(
            resources,
            R.color.colorBackground,
            null
        )
        private lateinit var extraCanvas: Canvas
        private lateinit var extraBitmap: Bitmap
        private lateinit var frame: Rect


        //everything about the brush
        public val paint = Paint().apply {
            color = drawColor
            isAntiAlias = true
            isDither = true
            style = Paint.Style.STROKE
            strokeJoin = Paint.Join.ROUND
            strokeCap = Paint.Cap.ROUND
            strokeWidth = STROKE_WIDTH
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
            extraCanvas.drawColor(backgroundColor)

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


    }
