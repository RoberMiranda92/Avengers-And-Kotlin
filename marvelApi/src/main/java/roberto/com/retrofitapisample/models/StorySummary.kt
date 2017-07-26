package roberto.com.retrofitapisample.models

import java.util.HashMap

data class StorySummary constructor(

    var resourceURI: String? = null,
    var name: String? = null,
    var type: String? = null) : BaseModel {


}
