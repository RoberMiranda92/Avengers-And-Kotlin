package roberto.com.retrofitapisample.models

import java.util.HashMap

class Character {

    var id: String? = null
    var name: String? = null
    var description: String? = null
    var modified: String? = null
    var resourceURI: String? = null
    var urls: List<Url>? = null
    var thumbnail: Thumbnail? = null
    var comics: ComicList? = null
    var stories: StoryList? = null
    var events: EventList? = null
    var series: SeriesList? = null

}
