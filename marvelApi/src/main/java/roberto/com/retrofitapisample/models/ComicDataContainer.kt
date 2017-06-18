package roberto.com.retrofitapisample.models

/**
 * Created by RobertoMiranda on 17/06/2017.
 */
class ComicDataContainer {

    var offset: Int = 0
    var limit: Int = 0
    var total: Int = 0
    var count: Int = 0
    var results: List<Comic>? = null
}