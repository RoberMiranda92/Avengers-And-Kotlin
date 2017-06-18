package testkotlin.com.mykotlinapplication.extensions

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by RobertoMiranda on 11/06/2017.
 */


fun ImageView.loadFromUrl(url: String) {

    Picasso.with(context).load(url).into(this)
}

