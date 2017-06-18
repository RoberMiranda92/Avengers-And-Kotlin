package testkotlin.com.mykotlinapplication.routing

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import testkotlin.com.mykotlinapplication.view.activity.ActivityWithToolbar

/**
 * Created by RobertoMiranda on 17/05/2017.
 */


class AppNavigation{


    companion object {
        fun navigateToMarvelActivity(from: AppCompatActivity){

            val intent = Intent(from, ActivityWithToolbar::class.java)
            from.startActivity(intent)
        }
    }

}