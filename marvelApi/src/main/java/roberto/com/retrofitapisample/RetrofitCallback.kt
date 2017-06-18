package roberto.com.retrofitapisample

/**
 * Created by robertomiranda on 18/5/17.
 */
interface RetrofitCallback<in Any> {

    fun onSucess(response: Any)
    fun onError(error: String?)
}