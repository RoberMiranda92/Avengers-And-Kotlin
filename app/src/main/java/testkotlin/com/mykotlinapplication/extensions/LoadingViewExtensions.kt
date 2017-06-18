package testkotlin.com.mykotlinapplication.extensions

import android.graphics.Color
import android.os.Build
import io.saeid.fabloading.LoadingView
import testkotlin.com.mykotlinapplication.R

/**
 * Created by RobertoMiranda on 11/06/2017.
 */

fun LoadingView.configureLoading() {


    val isLollipop = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
    val marvel_1 = if (isLollipop) R.drawable.marvel_1_lollipop else R.drawable.marvel_1
    val marvel_2 = if (isLollipop) R.drawable.marvel_2_lollipop else R.drawable.marvel_2
    val marvel_3 = if (isLollipop) R.drawable.marvel_3_lollipop else R.drawable.marvel_3
    val marvel_4 = if (isLollipop) R.drawable.marvel_4_lollipop else R.drawable.marvel_4
    this.addAnimation(Color.parseColor("#FFD200"), marvel_1,
            LoadingView.FROM_LEFT)
    this.addAnimation(Color.parseColor("#2F5DA9"), marvel_2,
            LoadingView.FROM_TOP)
    this.addAnimation(Color.parseColor("#FF4218"), marvel_3,
            LoadingView.FROM_RIGHT)
    this.addAnimation(Color.parseColor("#C7E7FB"), marvel_4,
            LoadingView.FROM_BOTTOM)

    this.addAnimation(Color.parseColor("#FF4218"), marvel_3, LoadingView.FROM_TOP)
    this.addAnimation(Color.parseColor("#C7E7FB"), marvel_4, LoadingView.FROM_BOTTOM)
    this.addAnimation(Color.parseColor("#FF4218"), marvel_3, LoadingView.FROM_TOP)
    this.addAnimation(Color.parseColor("#C7E7FB"), marvel_4, LoadingView.FROM_BOTTOM)


}