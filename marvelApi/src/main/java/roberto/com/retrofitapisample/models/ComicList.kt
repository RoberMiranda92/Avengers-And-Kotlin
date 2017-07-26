package roberto.com.retrofitapisample.models

import java.io.Serializable
import java.util.HashMap

data class ComicList constructor (

    var available: String? = null,
    var returned: String? = null,
    var collectionURI: String? = null,
    var items: List<ComicSummary>? = null) : BaseModel {

}
