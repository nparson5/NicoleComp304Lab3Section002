package nicole.parsons.s300941374


import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_nicole.*


class NicoleActivity : AppCompatActivity() ,
    RadioGroup.OnCheckedChangeListener{


  //  private  lateinit var nicoleCanvasView: NicoleCanvasView
  public var an: Animation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nicole)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)




        /*
        */

    }

    public fun setAnim(): Animation? {
        an = AnimationUtils.loadAnimation(this, R.anim.revolve)
return an
    }

    override fun onCheckedChanged(rg: RadioGroup, checkedId: Int) {

        val radio: RadioButton = findViewById(checkedId)
        when (checkedId) {
            1 -> print("x == 1")
            2 -> print("x == 2")
            else -> { // Note the block
                print("x is neither 1 nor 2")
            }
        }





    }


    override fun onBackPressed() {
        //super.onBackPressed();
        IsFinish(nav_view);
    }

    fun IsFinish(view: View){
        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle(R.string.alertMessageTitle)
            setMessage(R.string.alertMessage)
            setPositiveButton(R.string.ok, DialogInterface.OnClickListener(function = positiveButtonClick))
            setNegativeButton(R.string.cancel, null)
            setIcon(resources.getDrawable(android.R.drawable.ic_dialog_alert, theme))

        }
        val alertDialog = builder.create()
        alertDialog.show()


    }

    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        finishAffinity()
    }



}

