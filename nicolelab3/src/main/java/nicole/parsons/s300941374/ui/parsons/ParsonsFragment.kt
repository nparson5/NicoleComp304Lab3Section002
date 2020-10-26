package nicole.parsons.s300941374.ui.parsons
//Nicole Parsons - 300941374 - Section 002
import android.annotation.SuppressLint
import android.graphics.drawable.AnimationDrawable
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.Button
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_parsons.*
import nicole.parsons.s300941374.R

class ParsonsFragment : Fragment() {

    private lateinit var parsonsViewModel: ParsonsViewModel
    var nicoleFrameAnimation: AnimationDrawable? = null
    private var frameDuration = (3 * 1000 / 21)

    var an: Animation? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        parsonsViewModel =
            ViewModelProviders.of(this).get(ParsonsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_parsons, container, false)


        // Event-handlers
        val startBtn: Button = root.findViewById<Button>(R.id.nicoleStartBtn)
        startBtn.setOnClickListener {

            //  Toast.makeText(view?.context, "Button Clicked", Toast.LENGTH_LONG).show()

            startAnimation()
        }
        val stopBtn: Button = root.findViewById<Button>(R.id.nicoleStopBtn)
        stopBtn.setOnClickListener {

            //  Toast.makeText(view?.context, "Button Clicked", Toast.LENGTH_LONG).show()

            stopAnimation()
        }

        val radioGroup: RadioGroup = root.findViewById<RadioGroup>(R.id.nicoleSpeedRg)
        radioGroup.setOnCheckedChangeListener { _, _ ->
            changeSpeed()

        }

        val permissionsBtn: Button = root.findViewById<Button>(R.id.nicolePermissionsBtn)
        permissionsBtn.setOnClickListener {
            TODO("Ask for permissions")
//ask for permissions
        }

        return root
    }

    private fun changeSpeed() {

        if (nicoleSpeed1.isChecked) {
            frameDuration = (5 * 1000 / 21)//5 seconds, 1000ms per second, 21 frames
        }
        if (nicoleSpeed2.isChecked) {
            frameDuration = (3 * 1000 / 21)
        }

        if (nicoleSpeed3.isChecked) {
            frameDuration = (2 * 1000 / 21)//5 seconds, 1000ms per second, 21 frames
        }
        if (nicoleSpeed4.isChecked) {
            frameDuration = (1 * 1000 / 21)//5 seconds, 1000ms per second, 21 frames
        }




        startAnimation()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun startAnimation() {
        //21 frames
        //x duration for each frame

        val frame1 = context?.getDrawable(R.drawable.grim_animate_0001) as BitmapDrawable
        val frame2 = context?.getDrawable(R.drawable.grim_animate_0002) as BitmapDrawable
        val frame3 = context?.getDrawable(R.drawable.grim_animate_0003) as BitmapDrawable
        val frame4 = context?.getDrawable(R.drawable.grim_animate_0004) as BitmapDrawable
        val frame5 = context?.getDrawable(R.drawable.grim_animate_0005) as BitmapDrawable

        val frame6 = context?.getDrawable(R.drawable.grim_animate_0006) as BitmapDrawable
        val frame7 = context?.getDrawable(R.drawable.grim_animate_0007) as BitmapDrawable
        val frame8 = context?.getDrawable(R.drawable.grim_animate_0008) as BitmapDrawable
        val frame9 = context?.getDrawable(R.drawable.grim_animate_0009) as BitmapDrawable
        val frame10 = context?.getDrawable(R.drawable.grim_animate_0010) as BitmapDrawable

        val frame11 = context?.getDrawable(R.drawable.grim_animate_0011) as BitmapDrawable
        val frame12 = context?.getDrawable(R.drawable.grim_animate_0012) as BitmapDrawable
        val frame13 = context?.getDrawable(R.drawable.grim_animate_0013) as BitmapDrawable
        val frame14 = context?.getDrawable(R.drawable.grim_animate_0014) as BitmapDrawable
        val frame15 = context?.getDrawable(R.drawable.grim_animate_0015) as BitmapDrawable

        val frame16 = context?.getDrawable(R.drawable.grim_animate_0016) as BitmapDrawable
        val frame17 = context?.getDrawable(R.drawable.grim_animate_0017) as BitmapDrawable
        val frame18 = context?.getDrawable(R.drawable.grim_animate_0018) as BitmapDrawable
        val frame19 = context?.getDrawable(R.drawable.grim_animate_0019) as BitmapDrawable
        val frame20 = context?.getDrawable(R.drawable.grim_animate_0020) as BitmapDrawable
        val frame21 = context?.getDrawable(R.drawable.grim_animate_0021) as BitmapDrawable

        // Get the background, which has been compiled to an AnimationDrawable object.

        // Get the background, which has been compiled to an AnimationDrawable object.

        nicoleFrameAnimation = AnimationDrawable()
        nicoleFrameAnimation!!.isOneShot = false // loop continuously

        nicoleFrameAnimation!!.addFrame(frame1, frameDuration)
        nicoleFrameAnimation!!.addFrame(frame2, frameDuration)
        nicoleFrameAnimation!!.addFrame(frame3, frameDuration)
        nicoleFrameAnimation!!.addFrame(frame4, frameDuration)
        nicoleFrameAnimation!!.addFrame(frame5, frameDuration)

        nicoleFrameAnimation!!.addFrame(frame6, frameDuration)
        nicoleFrameAnimation!!.addFrame(frame7, frameDuration)
        nicoleFrameAnimation!!.addFrame(frame8, frameDuration)
        nicoleFrameAnimation!!.addFrame(frame9, frameDuration)
        nicoleFrameAnimation!!.addFrame(frame10, frameDuration)

        nicoleFrameAnimation!!.addFrame(frame11, frameDuration)
        nicoleFrameAnimation!!.addFrame(frame12, frameDuration)
        nicoleFrameAnimation!!.addFrame(frame13, frameDuration)
        nicoleFrameAnimation!!.addFrame(frame14, frameDuration)
        nicoleFrameAnimation!!.addFrame(frame15, frameDuration)

        nicoleFrameAnimation!!.addFrame(frame16, frameDuration)
        nicoleFrameAnimation!!.addFrame(frame17, frameDuration)
        nicoleFrameAnimation!!.addFrame(frame18, frameDuration)
        nicoleFrameAnimation!!.addFrame(frame19, frameDuration)
        nicoleFrameAnimation!!.addFrame(frame20, frameDuration)
        nicoleFrameAnimation!!.addFrame(frame21, frameDuration)

        nicoleImgAnimate.background = nicoleFrameAnimation

        nicoleFrameAnimation!!.setVisible(true, true)
        nicoleFrameAnimation!!.start()
    }

    private fun stopAnimation() {
        nicoleFrameAnimation?.stop()
        nicoleFrameAnimation?.setVisible(false, false)
    }

}
