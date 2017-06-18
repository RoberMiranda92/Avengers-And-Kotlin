package testkotlin.com.mykotlinapplication.presenter

import android.content.Context
import org.greenrobot.eventbus.EventBus

/**
 * Created by robertomiranda on 18/5/17.
 */

open class BasePresenter<T : BasePresenter.BaseContract> {

    protected var mView: T? = null
    private var isBusRegistered: Boolean = false

    private var offset: Int = 0
    private var limit: Int = 20


    open fun attachView(mView: T) {

        this.mView = mView
    }


    fun start() {
        if (!isBusRegistered) {
            EventBus.getDefault().register(this)
            isBusRegistered = true

        }
    }

    fun stop() {

        if (isBusRegistered) {
            EventBus.getDefault().unregister(this)
            isBusRegistered = false

        }

    }


    interface BaseContract {


        fun showLoading()
        fun hideLoading()
        fun getContext(): Context
        fun onError(error: String)
        fun setMaxData(count: Int)

    }
}
