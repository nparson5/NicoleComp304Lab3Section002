package nicole.parsons.s300941374.ui.nicole
//Nicole Parsons - 300941374 - Section 002
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_nicole.*
import nicole.parsons.s300941374.R

class NicoleFragment : Fragment() {

    private lateinit var nicoleViewModel: NicoleViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        nicoleViewModel =
            ViewModelProviders.of(this).get(NicoleViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_nicole, container, false)

        val radioGroupSize: RadioGroup = root.findViewById<RadioGroup>(R.id.nicoleSizeRg)
        radioGroupSize.setOnCheckedChangeListener { _, _ ->
            changeSize()

        }

        val radioGroupColor: RadioGroup = root.findViewById<RadioGroup>(R.id.nicoleColorRg)
        radioGroupColor.setOnCheckedChangeListener { _, _ ->
            changeColor()

        }

        val clearBtn: Button = root.findViewById<Button>(R.id.nicoleClearBtn)
        clearBtn.setOnClickListener {

            //  Toast.makeText(view?.context, "Button Clicked", Toast.LENGTH_LONG).show()
            val ft: FragmentTransaction = fragmentManager!!.beginTransaction()
            ft.detach(this).attach(this).commit()
        }

        val updateBtn: Button = root.findViewById<Button>(R.id.nicoleUpdateBtn)
        updateBtn.setOnClickListener {
            update()
        }



        return root
    }


    private fun changeSize() {

        if (nicoleSize1.isChecked) {
            //frameDuration = (5*1000/21)//5 seconds, 1000ms per second, 21 frames

            // Toast.makeText(view?.context, "Button Clicked", Toast.LENGTH_LONG).show()
            //nicoleCanvasView.paint.strokeWidth = 3f//this way of updating properties directly is easier than using a button.
            nicoleCanvasView.penWidth =
                3f//must update properties indirectly in accordance with the assignment specs.
        }
        if (nicoleSize2.isChecked) {
            // frameDuration = (3*1000/21)

           // Toast.makeText(view?.context, "Button Clicked", Toast.LENGTH_LONG).show()
            nicoleCanvasView.penWidth = 10f
        }

        if (nicoleSize3.isChecked) {

         //   Toast.makeText(view?.context, "Button Clicked", Toast.LENGTH_LONG).show()
            nicoleCanvasView.penWidth = 60f
        }


    }

    private fun changeColor() {

        if (nicoleColor1.isChecked) {
            //frameDuration = (5*1000/21)//5 seconds, 1000ms per second, 21 frames

            // Toast.makeText(view?.context, "Button Clicked", Toast.LENGTH_LONG).show()
            nicoleCanvasView.penColour = ResourcesCompat.getColor(resources, R.color.red, null)
        }
        if (nicoleColor2.isChecked) {
            // frameDuration = (3*1000/21)

            // Toast.makeText(view?.context, "Button Clicked", Toast.LENGTH_LONG).show()
            nicoleCanvasView.penColour = ResourcesCompat.getColor(resources, R.color.black, null)
        }

        if (nicoleColor3.isChecked) {

            //   Toast.makeText(view?.context, "Button Clicked", Toast.LENGTH_LONG).show()
            nicoleCanvasView.penColour = ResourcesCompat.getColor(resources, R.color.blue, null)
        }


    }

    private fun update() {
        nicoleCanvasView.updatePen()//only update properties when user clicks update

    }








}
