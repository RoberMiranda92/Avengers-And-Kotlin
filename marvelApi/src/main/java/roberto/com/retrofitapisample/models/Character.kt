package roberto.com.retrofitapisample.models

import java.io.Serializable


data class Character constructor(


    var id: String?,
    var name: String?,
    var description: String?,
    var modified: String?,
    var resourceURI: String?,
    var urls: List<Url>?,
    var thumbnail: Thumbnail?,
    var comics: ComicList?,
    var stories: StoryList?,
    var events: EventList?,
    var series: SeriesList?) : BaseModel {}

