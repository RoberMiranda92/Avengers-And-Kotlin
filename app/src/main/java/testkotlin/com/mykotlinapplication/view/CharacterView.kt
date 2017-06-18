package testkotlin.com.mykotlinapplication.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import roberto.com.retrofitapisample.models.Character
import testkotlin.com.mykotlinapplication.R
import testkotlin.com.mykotlinapplication.extensions.getImageUrl
import testkotlin.com.mykotlinapplication.extensions.loadFromUrl

/**
 * Created by RobertoMiranda on 16/06/2017.
 */
class CharacterView : RelativeLayout {


    @BindView(R.id.character_imageview)
    lateinit var mImageView: ImageView
    @BindView(R.id.character_textView)
    lateinit var mTextView: TextView


    constructor(context: Context) : super(context) {
        iniView()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        iniView()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        iniView()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        iniView()
    }


    private fun iniView() {
        var v: View = LayoutInflater.from(context).inflate(R.layout.characters_view, this)
        ButterKnife.bind(this, v)

    }


    fun setCharacter(character: Character) {

        mTextView.text = character.name;
        mImageView.loadFromUrl(url = character.getImageUrl())

    }
}