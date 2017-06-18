package testkotlin.com.mykotlinapplication.domain

import android.content.Context
import android.util.Log
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import roberto.com.retrofitapisample.ApiManager
import roberto.com.retrofitapisample.CharactersRepository
import roberto.com.retrofitapisample.models.CharacterDataWrapper

/**
 * Created by robertomiranda on 18/5/17.
 */

class CharacterController {


    private val TAG: String = CharacterController::class.java.simpleName
    private lateinit var mRetrofitApi: ApiManager
    private var mModule: CharactersRepository? = null


    private var mContext: Context? = null

    companion object {
        private var mInstance: CharacterController? = null

        fun getInstance(context: Context): CharacterController {
            if (mInstance == null) {
                mInstance = CharacterController(context)
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
            mModule = mRetrofitApi.getModule<CharactersRepository>(ApiManager.CHARACTERS)

        } catch (ex: Exception) {
            Log.e(TAG, ex.message!!)
        }
    }


    fun getCharacters(offSet: Int) {

        mModule?.getAllCharacters(1, offSet, mRetrofitApi.mPublicKey, mRetrofitApi.mHashKey)
                ?.enqueue(object : Callback<CharacterDataWrapper> {
                    override fun onResponse(call: Call<CharacterDataWrapper>?,
                                            response: Response<CharacterDataWrapper>?) {
                        if (response!!.isSuccessful) {
                            EventBus.getDefault().post(response.body())

                        } else {
                            onFailure(call, Throwable("Invalid Response"))

                        }
                    }

                    override fun onFailure(call: Call<CharacterDataWrapper>?, t: Throwable?) {
                        EventBus.getDefault().post(t?.message!!)

                    }


                })


    }

    fun getAvengers(offSet: Int) {
        mModule?.getAvengersCharacters(1, offSet, 9085, mRetrofitApi.mPublicKey, mRetrofitApi.mHashKey)
                ?.enqueue(object : Callback<CharacterDataWrapper> {
                    override fun onResponse(call: Call<CharacterDataWrapper>?,
                                            response: Response<CharacterDataWrapper>?) {
                        if (response!!.isSuccessful) {
                            EventBus.getDefault().post(response.body())

                        } else {
                            onFailure(call, Throwable("Invalid Response"))

                        }
                    }

                    override fun onFailure(call: Call<CharacterDataWrapper>?, t: Throwable?) {
                        EventBus.getDefault().post(t?.message!!)

                    }


                })
    }

    fun getFantasticFour(offSet: Int) {
        mModule?.getAvengersCharacters(1, offSet, 725, mRetrofitApi.mPublicKey, mRetrofitApi.mHashKey)
                ?.enqueue(object : Callback<CharacterDataWrapper> {
                    override fun onResponse(call: Call<CharacterDataWrapper>?,
                                            response: Response<CharacterDataWrapper>?) {
                        if (response!!.isSuccessful) {
                            EventBus.getDefault().post(response.body())

                        } else {
                            onFailure(call, Throwable("Invalid Response"))

                        }
                    }

                    override fun onFailure(call: Call<CharacterDataWrapper>?, t: Throwable?) {
                        EventBus.getDefault().post(t?.message!!)

                    }


                })
    }


}