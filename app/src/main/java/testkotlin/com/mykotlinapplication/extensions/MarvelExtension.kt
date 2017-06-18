package testkotlin.com.mykotlinapplication.extensions

import roberto.com.retrofitapisample.models.Character
import roberto.com.retrofitapisample.models.Comic

/**
 * Created by RobertoMiranda on 16/06/2017.
 */


fun Character.getImageUrl(): String {

    return this.thumbnail!!.path + "." + this.thumbnail!!.extension
}

fun Comic.getImageUrl(): String {
    return this.thumbnail!!.path + "." + this.thumbnail!!.extension;
}