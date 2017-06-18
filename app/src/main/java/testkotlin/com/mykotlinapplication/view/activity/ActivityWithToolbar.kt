package testkotlin.com.mykotlinapplication.view.activity

import android.support.v4.app.Fragment
import butterknife.BindView
import testkotlin.com.mykotlinapplication.R
import testkotlin.com.mykotlinapplication.view.fragments.CharactersFragment
import testkotlin.com.mykotlinapplication.view.fragments.ComicFragment

open class ActivityWithToolbar : BaseActivity() {


    @BindView(testkotlin.com.mykotlinapplication.R.id.main_toolbar)
    lateinit var mToolbar: android.support.v7.widget.Toolbar
    @BindView(testkotlin.com.mykotlinapplication.R.id.main_frame)
    lateinit var mFrameLayout: android.widget.FrameLayout
    @BindView(testkotlin.com.mykotlinapplication.R.id.navigation)
    lateinit var navigation: android.support.design.widget.BottomNavigationView

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)

        setActionBar(mToolbar)

    }

    private fun setActionBar(toolbar: android.support.v7.widget.Toolbar) {

        setSupportActionBar(toolbar)
    }

    override fun getLayoutId(): Int {
        return testkotlin.com.mykotlinapplication.R.layout.activity_with_toolbar
    }

    override fun prepareView() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        setFragment(CharactersFragment())
    }

    private val mOnNavigationItemSelectedListener = android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            testkotlin.com.mykotlinapplication.R.id.navigation_characters -> {
                setFragment(CharactersFragment())
                return@OnNavigationItemSelectedListener true
            }
            testkotlin.com.mykotlinapplication.R.id.navigation_comics -> {
                setFragment(ComicFragment())

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


    private fun setFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_frame, fragment)
        fragmentTransaction.commit()

    }


}
