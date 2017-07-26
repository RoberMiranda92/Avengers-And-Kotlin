package roberto.com.retrofitapisample.models

import java.io.Serializable

/**
 * Created by RobertoMiranda on 17/06/2017.
 */
data class CharacterSummary constructor(

    var resourceURI: String? = null,
    var name: String? = null,
    var role: String? = null) : BaseModel {

}