package testkotlin.com.mykotlinapplication

import android.app.Application
import roberto.com.retrofitapisample.ApiManager

/**
 * Created by RobertoMiranda on 11/06/2017.
 */

class MainApplication : Application() {


    override fun onCreate() {
        super.onCreate()
        val api:ApiManager = ApiManager.getInstance(this)
        api.setKeys(this.resources.getString(R.string.public_key), this.resources.getString(R.string.private_key))

    }


}


