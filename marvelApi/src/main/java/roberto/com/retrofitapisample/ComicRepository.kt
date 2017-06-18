package roberto.com.retrofitapisample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import roberto.com.retrofitapisample.models.ComicDataWrapper

/**
 * Created by RobertoMiranda on 11/06/2017.
 */
interface ComicRepository {


    @GET("/v1/public/comics")
    fun getAllComics(@Query("ts") timeStamp: Int, @Query("offset") offset: Int, @Query("apikey") apiKey: String, @Query("hash") hash: String): Call<ComicDataWrapper>


    @GET("/v1/public/comics")
    fun getAvengersComic(@Query("ts") timeStamp: Int, @Query("offset") offset: Int, @Query("series") story: Int, @Query("apikey") apiKey: String, @Query("hash") hash: String): Call<ComicDataWrapper>


}