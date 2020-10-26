package nicole.parsons.s300941374.ui.s300941374
//Nicole Parsons - 300941374 - Section 002
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_s300941374.*
import nicole.parsons.s300941374.R

class S300941374Fragment : Fragment() {

    private lateinit var s300941374ViewModel: S300941374ViewModel


    var an: Animation? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        s300941374ViewModel =
            ViewModelProviders.of(this).get(S300941374ViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_s300941374, container, false)



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

        return root
    }

    private fun startAnimation() {
        an = AnimationUtils.loadAnimation(activity, R.anim.revolve)
        nicoleImgEarth?.startAnimation(an)
    }

    private fun stopAnimation() {
        nicoleImgEarth?.clearAnimation()
    }

}
