package roberto.com.retrofitapisample

import android.content.Context
import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Created by RobertoMiranda on 17/05/2017.
 */


class ApiManager {

    private val TAG: String = ApiManager::class.java.simpleName

    private lateinit var mApi: Retrofit
    private var mContext: Context? = null
    var mPublicKey: String = ""
    var mprivateKey: String = ""
    var mHashKey: String = ""

    private lateinit var mModuleList: HashMap<String, Any>

    companion object {
        private var mInstance: ApiManager? = null
        @JvmStatic val CHARACTERS: String = "Characters"
        @JvmStatic val COMIC: String = "Comic"


        fun getInstance(context: Context): ApiManager {
            if (mInstance == null) {
                mInstance = ApiManager(context)
            }

            return mInstance!!
        }
    }

    private constructor() {

    }

    private constructor(context: Context) {
        this.mContext = context
        initApi()
        initModules()
    }

    private fun initApi() {
        mApi = Retrofit.Builder().baseUrl(getBaseUrl()!!).addConverterFactory(MoshiConverterFactory.create()).build()

    }

    private fun initModules() {

        mModuleList = HashMap()
        mModuleList.put(CHARACTERS, mApi.create(CharactersRepository::class.java))
        mModuleList.put(COMIC, mApi.create(ComicRepository::class.java))

    }


    fun setKeys(publicKey: String, privateKey: String) {

        this.mPublicKey = publicKey
        this.mprivateKey = privateKey

        var md5String = "1" + privateKey + publicKey


        val md = MessageDigest.getInstance("MD5")
        val messageDigest = md.digest(md5String.toByteArray())
        val number = BigInteger(1, messageDigest)
        this.mHashKey = number.toString(16)


    }

    private fun getBaseUrl(): String? {

        return mContext!!.getString(R.string.apiURL)
    }


    fun <T> getModule(name: String): T? {

        if (mPublicKey.isEmpty() || mprivateKey.isEmpty()) {
            throw Exception("No key set in api")
        }

        try {
            return mModuleList.get(name) as T
        } catch (ex: ClassCastException) {
            Log.e(TAG, ex.message!!)
        }


        return null
    }
}