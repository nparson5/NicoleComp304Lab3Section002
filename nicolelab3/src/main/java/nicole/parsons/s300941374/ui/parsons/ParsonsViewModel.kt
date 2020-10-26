package nicole.parsons.s300941374.ui.parsons
//Nicole Parsons - 300941374 - Section 002
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ParsonsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is parsons Fragment"
    }
    val text: LiveData<String> = _text
}