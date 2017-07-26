package roberto.com.retrofitapisample.models

import java.io.Serializable

/**
 * Created by RobertoMiranda on 17/06/2017.
 */
data class CharacterList constructor(

    var available: Int = 0,
    var returned: Int = 0,
    var collectionURI:String? = null,
    var items:List<CharacterSummary>? = null) : BaseModel {
}

