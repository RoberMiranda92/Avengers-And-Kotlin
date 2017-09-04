package roberto.com.retrofitapisample.models


/**
 * Created by RobertoMiranda on 17/06/2017.
 */
data class CreatorSummary constructor (

    var resourceURI: String? = null,
    var name: String? = null,
    var rolerent: String? = null) : BaseModel {
}