package testkotlin.com.mykotlinapplication.view.activity


import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import com.f2prateek.dart.Dart
import com.f2prateek.dart.InjectExtra
import com.f2prateek.dart.Nullable
import roberto.com.retrofitapisample.models.Character
import testkotlin.com.mykotlinapplication.R
import testkotlin.com.mykotlinapplication.view.fragments.DetailFragment


/**
 * Created by bernatgomez on 23/7/17.
 */
class DetailActivity() : BaseActivity() {

    @Nullable
    @InjectExtra("extra_character")
    lateinit var extra_character : Character

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        this.injectExtras()

        if (savedInstanceState == null) {
            this.launchContentFragment()
        }
    }

    private fun injectExtras() {
        Dart.inject(this)

        this.extra_character = this.intent.getSerializableExtra(DetailFragment.CHARACTER_EXTRA) as Character
    }

    private fun launchContentFragment() {
        val mgr : FragmentManager = this.supportFragmentManager

        val trans : FragmentTransaction = mgr.beginTransaction()

        val f : DetailFragment = DetailFragment.newInstance(this.extra_character)

        trans.replace(R.id.mainContainer, f)

        trans.commit()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_detail
    }

    override fun prepareView() {

    }
}