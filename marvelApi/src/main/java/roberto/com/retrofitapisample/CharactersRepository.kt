package roberto.com.retrofitapisample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import roberto.com.retrofitapisample.models.CharacterDataWrapper

/**
 * Created by RobertoMiranda on 17/05/2017.
 */
interface CharactersRepository {

    @GET("/v1/public/characters")
    fun getAllCharacters(@Query("ts") timeStamp: Int, @Query("offset") offset: Int, @Query("apikey") apiKey: String, @Query("hash") hash: String): Call<CharacterDataWrapper>


    @GET("/v1/public/characters")
    fun getAvengersCharacters(@Query("ts") timeStamp: Int, @Query("offset") offset: Int, @Query("series") story: Int, @Query("apikey") apiKey: String, @Query("hash") hash: String): Call<CharacterDataWrapper>

}