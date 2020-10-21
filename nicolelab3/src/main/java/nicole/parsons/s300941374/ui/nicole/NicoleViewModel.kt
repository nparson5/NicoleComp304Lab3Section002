package nicole.parsons.s300941374.ui.nicole

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NicoleViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is nicole Fragment"
    }
    val text: LiveData<String> = _text
}