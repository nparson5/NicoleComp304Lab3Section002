package nicole.parsons.s300941374.ui.parsons

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
    var reasonableDuration = (3*1000/21)

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
        val startBtn : Button = root.findViewById<Button>(R.id.nicoleStartBtn)
        startBtn.setOnClickListener{

            //  Toast.makeText(view?.context, "Button Clicked", Toast.LENGTH_LONG).show()

            startAnimation()
        }
        val stopBtn : Button = root.findViewById<Button>(R.id.nicoleStopBtn)
        stopBtn.setOnClickListener{

            //  Toast.makeText(view?.context, "Button Clicked", Toast.LENGTH_LONG).show()

            stopAnimation()
        }

        val radioGroup : RadioGroup = root.findViewById<RadioGroup>(R.id.nicoleSpeedRg)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            changeSpeed(checkedId)

        }

        return root
    }

    private fun changeSpeed(checkedID: Int){

            if (nicoleSpeed1.isChecked) {
                reasonableDuration = (5*1000/21)//5 seconds, 1000ms per second, 21 frames
            }
            if (nicoleSpeed2.isChecked) {
                reasonableDuration = (3*1000/21)
            }

            if (nicoleSpeed3.isChecked) {
                reasonableDuration = (2*1000/21)//5 seconds, 1000ms per second, 21 frames
            }
            if (nicoleSpeed4.isChecked) {
                reasonableDuration = (1*1000/21)//5 seconds, 1000ms per second, 21 frames
            }




        startAnimation()
    }

    private fun startAnimation() {
        //21 frames
        //x duration for each frame

        val frame1 = resources.getDrawable(R.drawable.grim_animate_0001) as BitmapDrawable
        val frame2 = resources.getDrawable(R.drawable.grim_animate_0002) as BitmapDrawable
        val frame3 = resources.getDrawable(R.drawable.grim_animate_0003) as BitmapDrawable
        val frame4 = resources.getDrawable(R.drawable.grim_animate_0004) as BitmapDrawable
        val frame5 = resources.getDrawable(R.drawable.grim_animate_0005) as BitmapDrawable

        val frame6 = resources.getDrawable(R.drawable.grim_animate_0006) as BitmapDrawable
        val frame7 = resources.getDrawable(R.drawable.grim_animate_0007) as BitmapDrawable
        val frame8 = resources.getDrawable(R.drawable.grim_animate_0008) as BitmapDrawable
        val frame9 = resources.getDrawable(R.drawable.grim_animate_0009) as BitmapDrawable
        val frame10 = resources.getDrawable(R.drawable.grim_animate_0010) as BitmapDrawable

        val frame11 = resources.getDrawable(R.drawable.grim_animate_0011) as BitmapDrawable
        val frame12 = resources.getDrawable(R.drawable.grim_animate_0012) as BitmapDrawable
        val frame13 = resources.getDrawable(R.drawable.grim_animate_0013) as BitmapDrawable
        val frame14 = resources.getDrawable(R.drawable.grim_animate_0014) as BitmapDrawable
        val frame15 = resources.getDrawable(R.drawable.grim_animate_0015) as BitmapDrawable

        val frame16 = resources.getDrawable(R.drawable.grim_animate_0016) as BitmapDrawable
        val frame17 = resources.getDrawable(R.drawable.grim_animate_0017) as BitmapDrawable
        val frame18 = resources.getDrawable(R.drawable.grim_animate_0018) as BitmapDrawable
        val frame19 = resources.getDrawable(R.drawable.grim_animate_0019) as BitmapDrawable
        val frame20 = resources.getDrawable(R.drawable.grim_animate_0020) as BitmapDrawable
        val frame21 = resources.getDrawable(R.drawable.grim_animate_0021) as BitmapDrawable

        // Get the background, which has been compiled to an AnimationDrawable object.

        // Get the background, which has been compiled to an AnimationDrawable object.

        nicoleFrameAnimation = AnimationDrawable()
        nicoleFrameAnimation!!.setOneShot(false) // loop continuously

        nicoleFrameAnimation!!.addFrame(frame1, reasonableDuration)
        nicoleFrameAnimation!!.addFrame(frame2, reasonableDuration)
        nicoleFrameAnimation!!.addFrame(frame3, reasonableDuration)
        nicoleFrameAnimation!!.addFrame(frame4, reasonableDuration)
        nicoleFrameAnimation!!.addFrame(frame5, reasonableDuration)

        nicoleFrameAnimation!!.addFrame(frame6, reasonableDuration)
        nicoleFrameAnimation!!.addFrame(frame7, reasonableDuration)
        nicoleFrameAnimation!!.addFrame(frame8, reasonableDuration)
        nicoleFrameAnimation!!.addFrame(frame9, reasonableDuration)
        nicoleFrameAnimation!!.addFrame(frame10, reasonableDuration)

        nicoleFrameAnimation!!.addFrame(frame11, reasonableDuration)
        nicoleFrameAnimation!!.addFrame(frame12, reasonableDuration)
        nicoleFrameAnimation!!.addFrame(frame13, reasonableDuration)
        nicoleFrameAnimation!!.addFrame(frame14, reasonableDuration)
        nicoleFrameAnimation!!.addFrame(frame15, reasonableDuration)

        nicoleFrameAnimation!!.addFrame(frame16, reasonableDuration)
        nicoleFrameAnimation!!.addFrame(frame17, reasonableDuration)
        nicoleFrameAnimation!!.addFrame(frame18, reasonableDuration)
        nicoleFrameAnimation!!.addFrame(frame19, reasonableDuration)
        nicoleFrameAnimation!!.addFrame(frame20, reasonableDuration)
        nicoleFrameAnimation!!.addFrame(frame21, reasonableDuration)

        nicoleImgAnimate.background = nicoleFrameAnimation

        nicoleFrameAnimation!!.setVisible(true, true)
        nicoleFrameAnimation!!.start()
    }

    private fun stopAnimation() {
        nicoleFrameAnimation?.stop()
        nicoleFrameAnimation?.setVisible(false, false)
    }

}
