package nicole.parsons.s300941374.ui.nicole

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
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
        return root



    }












}
