package testkotlin.com.mykotlinapplication.view.activity

import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import butterknife.BindView
import io.saeid.fabloading.LoadingView
import testkotlin.com.mykotlinapplication.R
import testkotlin.com.mykotlinapplication.extensions.configureLoading
import testkotlin.com.mykotlinapplication.extensions.loadFromUrl
import testkotlin.com.mykotlinapplication.routing.AppNavigation


/**
 * Created by robertomiranda on 11/4/17.
 */

class SplashActivity : BaseActivity() {


    @BindView(R.id.progress_view)
    lateinit var image: LoadingView

    private val DELAY_TIME: Long = 3500


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        image.configureLoading()
        image.startAnimation()

        navigateWithDelayed()

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun prepareView() {
    }

    private fun navigateWithDelayed() {
        Handler().postDelayed(object : Runnable {
            override fun run() {
                AppNavigation.navigateToMarvelActivity(this@SplashActivity)
                this@SplashActivity.finish()
            }

        }, DELAY_TIME)
    }


}
