package roberto.com.retrofitapisample.models

import java.io.Serializable
import java.util.HashMap

data class CharacterDataWrapper constructor(

    var code: String? = null,
    var status: String? = null,
    var copyright: String? = null,
    var attributionText: String? = null,
    var attributionHTML: String? = null,
    var data: CharacterDataContainer? = null,
    var etag: String? = null) : BaseModel {

}
