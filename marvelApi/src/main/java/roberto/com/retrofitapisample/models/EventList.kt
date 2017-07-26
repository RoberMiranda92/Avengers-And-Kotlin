package roberto.com.retrofitapisample.models

import java.io.Serializable
import java.util.HashMap

class EventList : BaseModel {

    var available: String? = null
    var returned: String? = null
    var collectionURI: String? = null
    var items: List<EventSummary>? = null


}
