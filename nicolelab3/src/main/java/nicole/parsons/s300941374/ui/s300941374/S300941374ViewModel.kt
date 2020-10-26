package nicole.parsons.s300941374.ui.s300941374
//Nicole Parsons - 300941374 - Section 002
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class S300941374ViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is s300941374 Fragment"
    }
    val text: LiveData<String> = _text
}