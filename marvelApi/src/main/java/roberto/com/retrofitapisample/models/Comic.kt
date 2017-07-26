package roberto.com.retrofitapisample.models

import java.io.Serializable

/**
 * Created by RobertoMiranda on 17/06/2017.
 */
data class Comic constructor(

    var id: Int = 0,
    var digitalId: Int = 0,
    var title: String? = null,
    var issueNumber: Double = 0.0,
    var variantDescription: String? = null,
    var description: String? = null,
    var modified: String? = null,
    var isbn: String? = null,
    var upc: String? = null,
    var diamonCode: String? = null,
    var ean: String? = null,
    var issn: String? = null,
    var format: String? = null,
    var pageCount: Int = 0,
    var textObjects: List<TextObject>? = null,
    var resourceURI: String? = null,
    var urls: List<Url>? = null,
    var series: SeriesSummary? = null,
    var variants: List<ComicSummary>? = null,
    var collections: List<ComicSummary>? = null,
    var collectedIssues: List<ComicSummary>? = null,
    var dates: List<ComicDate>? = null,
    var prices: List<ComicPrice>? = null,
    var thumbnail: Image? = null,
    var images: List<Image>? = null,
    var creators: CreatorList? = null,
    var characters: CharacterList? = null,
    var stories: StoryList? = null,
    var events: EventList? = null) : BaseModel {
}