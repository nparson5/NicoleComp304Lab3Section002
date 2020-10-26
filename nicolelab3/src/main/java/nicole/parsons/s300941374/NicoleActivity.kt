package nicole.parsons.s300941374
//Nicole Parsons - 300941374 - Section 002

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView


class NicoleActivity : AppCompatActivity() {


    //  private  lateinit var nicoleCanvasView: NicoleCanvasView
    var an: Animation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nicole)
        val navView: BottomNavigationView = findViewById(R.id.nicole_nav_view)

        val navController = findNavController(R.id.nicole_nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)



    }





    override fun onBackPressed() {
        //super.onBackPressed();
        IsFinish()
    }

    fun IsFinish() {
        val builder = AlertDialog.Builder(this)
        with(builder) {
            setTitle(R.string.alertMessageTitle)
            setMessage(R.string.alertMessage)
            setPositiveButton(
                R.string.ok,
                DialogInterface.OnClickListener(function = positiveButtonClick)
            )
            setNegativeButton(R.string.cancel, null)
            setIcon(context?.getDrawable(android.R.drawable.ic_dialog_alert))

        }
        val alertDialog = builder.create()
        alertDialog.show()


    }

    private val positiveButtonClick = { _: DialogInterface, _: Int ->
        finishAffinity()
    }



}

