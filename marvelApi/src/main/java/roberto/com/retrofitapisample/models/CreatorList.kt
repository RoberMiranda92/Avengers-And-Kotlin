package roberto.com.retrofitapisample.models

/**
 * Created by RobertoMiranda on 17/06/2017.
 */
data class CreatorList constructor(

    var available: String? = null,
    var returned: String? = null,
    var collectionURI: String? = null,
    var items: List<CreatorSummary>? = null) : BaseModel {
}

