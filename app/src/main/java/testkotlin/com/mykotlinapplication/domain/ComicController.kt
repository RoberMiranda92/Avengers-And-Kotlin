package testkotlin.com.mykotlinapplication.domain

import android.content.Context
import android.util.Log
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import roberto.com.retrofitapisample.ApiManager
import roberto.com.retrofitapisample.ComicRepository
import roberto.com.retrofitapisample.models.ComicDataWrapper

/**
 * Created by RobertoMiranda on 17/06/2017.
 */
class ComicController {

    private val TAG: String = ComicController::class.java.simpleName
    private lateinit var mRetrofitApi: ApiManager
    private var mModule: ComicRepository? = null


    private var mContext: Context? = null

    companion object {
        private var mInstance: ComicController? = null

        fun getInstance(context: Context): ComicController {
            if (mInstance == null) {
                mInstance = ComicController(context)
            }

            return mInstance!!
        }
    }

    private constructor() {

    }

    private constructor(context: Context) {
        this.mContext = context
        initApi()
    }


    private fun initApi() {
        mRetrofitApi = ApiManager.getInstance(mContext!!)

        try {
            mModule = mRetrofitApi.getModule<ComicRepository>(ApiManager.COMIC)

        } catch (ex: Exception) {
            Log.e(TAG, ex.message!!)
        }
    }


    fun getCharacters(offSet: Int) {

        mModule?.getAllComics(1, offSet, mRetrofitApi.mPublicKey, mRetrofitApi.mHashKey)
                ?.enqueue(object : Callback<ComicDataWrapper> {
                    override fun onResponse(call: Call<ComicDataWrapper>?,
                                            response: Response<ComicDataWrapper>?) {
                        if (response!!.isSuccessful) {
                            EventBus.getDefault().post(response.body())

                        } else {
                            onFailure(call, Throwable("Invalid Response"))

                        }
                    }

                    override fun onFailure(call: Call<ComicDataWrapper>?, t: Throwable?) {
                        EventBus.getDefault().post(t?.message!!)

                    }


                })


    }

    fun getAvengers(offSet: Int) {
        mModule?.getAvengersComic(1, offSet, 9085, mRetrofitApi.mPublicKey, mRetrofitApi.mHashKey)
                ?.enqueue(object : Callback<ComicDataWrapper> {
                    override fun onResponse(call: Call<ComicDataWrapper>?,
                                            response: Response<ComicDataWrapper>?) {
                        if (response!!.isSuccessful) {
                            EventBus.getDefault().post(response.body())

                        } else {
                            onFailure(call, Throwable("Invalid Response"))

                        }
                    }

                    override fun onFailure(call: Call<ComicDataWrapper>?, t: Throwable?) {
                        EventBus.getDefault().post(t?.message!!)

                    }


                })
    }

    fun getFantasticFour(offSet: Int) {
        mModule?.getAvengersComic(1, offSet, 725, mRetrofitApi.mPublicKey, mRetrofitApi.mHashKey)
                ?.enqueue(object : Callback<ComicDataWrapper> {
                    override fun onResponse(call: Call<ComicDataWrapper>?,
                                            response: Response<ComicDataWrapper>?) {
                        if (response!!.isSuccessful) {
                            EventBus.getDefault().post(response.body())

                        } else {
                            onFailure(call, Throwable("Invalid Response"))

                        }
                    }

                    override fun onFailure(call: Call<ComicDataWrapper>?, t: Throwable?) {
                        EventBus.getDefault().post(t?.message!!)

                    }


                })
    }
}
