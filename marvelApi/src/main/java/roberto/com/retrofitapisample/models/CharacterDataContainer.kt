package roberto.com.retrofitapisample.models

import java.io.Serializable

data class CharacterDataContainer constructor (
    var offset: Int = 0,
    var limit: Int = 0,
    var total: Int = 0,
    var count: Int = 0,
    var results: List<Character>? = null) : BaseModel {

}
