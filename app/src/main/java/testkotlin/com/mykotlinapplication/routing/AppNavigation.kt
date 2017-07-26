package testkotlin.com.mykotlinapplication.routing

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.view.View
import roberto.com.retrofitapisample.models.Character
import testkotlin.com.mykotlinapplication.view.activity.ActivityWithToolbar
import testkotlin.com.mykotlinapplication.view.activity.DetailActivity
import testkotlin.com.mykotlinapplication.view.fragments.DetailFragment
import testkotlin.com.mykotlinapplication.viewmodels.CharacterVM

/**
 * Created by RobertoMiranda on 17/05/2017.
 */


class AppNavigation{

    companion object {
        fun navigateToMarvelActivity(from: AppCompatActivity){
            navigateTo(from, ActivityWithToolbar::class.java, null)
        }

        fun navigateToDetailActivity(from : FragmentActivity, vm : CharacterVM) {
            val b : Bundle = Bundle()

            b.putSerializable(DetailFragment.CHARACTER_EXTRA, vm.model)

            navigateTo(from, DetailActivity::class.java, b, vm.view)
        }

        private fun <T> navigateTo(from : FragmentActivity, target : Class<T>, b : Bundle?, sharedView : View? = null) {
            var sharedData : Bundle
            val intent = Intent(from, target)

            if (b != null) {
                intent.putExtras(b)
            }

            if (sharedView == null) {
                from.startActivity(intent)
            } else {
                sharedData = ActivityOptionsCompat.makeSceneTransitionAnimation(from, sharedView, "list_detail_transition").toBundle()
                from.startActivity(intent, sharedData)
            }
        }
    }

}