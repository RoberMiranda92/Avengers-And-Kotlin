package roberto.com.retrofitapisample.models

/**
 * Created by RobertoMiranda on 17/06/2017.
 */

data class ComicDataWrapper constructor(

    var code: Int = 0,
    var status: String? = null,
    var copyright: String? = null,
    var attributionText: String? = null,
    var attributionHTML: String? = null,
    var data: ComicDataContainer? = null,
    var etag: String? = null) : BaseModel {
}