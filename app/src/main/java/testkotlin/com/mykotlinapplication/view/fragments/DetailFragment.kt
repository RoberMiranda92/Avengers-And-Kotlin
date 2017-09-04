package testkotlin.com.mykotlinapplication.view.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.transition.Slide
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import roberto.com.retrofitapisample.models.Character
import testkotlin.com.mykotlinapplication.R
import testkotlin.com.mykotlinapplication.extensions.getImageUrl
import testkotlin.com.mykotlinapplication.extensions.loadFromUrl

/**
 * Created by bernatgomez on 23/7/17.
 */
class DetailFragment : Fragment() {

    @BindView(R.id.detailImg)
    lateinit var img : ImageView

    @BindView(R.id.detailTitle)
    lateinit var title : TextView

    @BindView(R.id.contentContainer)
    lateinit var contentContainer : CardView

    @BindView(R.id.detailContent)
    lateinit var content : TextView

    lateinit var charData : Character


    companion object {
        val CHARACTER_EXTRA = "extra_character"

        fun newInstance(charData : Character) : DetailFragment {
            val b : Bundle = Bundle()

            b.putSerializable(CHARACTER_EXTRA, charData)

            val f = DetailFragment()

            f.arguments = b

            return f
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.extractData()
    }


    private fun extractData() {
        if (this.arguments != null) {
            charData = this.arguments.get(CHARACTER_EXTRA) as Character
        }
    }

    private fun injectViews(v : View) {
        ButterKnife.bind(this, v)
    }

    private fun setValues() {
        this.title.text = charData.name

        if (!charData.description.isNullOrEmpty()) {
            this.content.text = charData.description
        }

        this.img.loadFromUrl(this.charData.getImageUrl())
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val v : View = inflater?.inflate(R.layout.fragment_detail, container, false) as View

        injectViews(v)

        return v
    }

    override fun onResume() {
        super.onResume()

        this.setValues()

        this.animateText()
    }

    private fun animateText() {
        val slide : Slide = Slide(Gravity.BOTTOM)

        slide.addTarget(this.contentContainer)

        slide.duration =1000

        slide.interpolator = AnimationUtils.loadInterpolator(this.activity, android.R.interpolator.linear_out_slow_in)

        this.activity.window.enterTransition = slide
    }
}

