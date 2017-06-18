package testkotlin.com.mykotlinapplication.view.fragments;

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.RelativeLayout
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import io.saeid.fabloading.LoadingView
import roberto.com.retrofitapisample.models.Comic
import testkotlin.com.mykotlinapplication.R
import testkotlin.com.mykotlinapplication.extensions.configureLoading
import testkotlin.com.mykotlinapplication.presenter.ComicPresenter
import testkotlin.com.mykotlinapplication.view.adapters.CharactersAdapter
import testkotlin.com.mykotlinapplication.view.adapters.ComicAdapter


class ComicFragment : Fragment(), ComicPresenter.ComicContrac, CharactersAdapter.CharactersListCallBack {
    private var finish: Boolean = false


    @BindView(R.id.loading_view)
    lateinit var mProgressView: RelativeLayout
    @BindView(R.id.comic_list)
    lateinit var mCharactersView: GridView
    @BindView(R.id.progress_view)
    lateinit var loadinf: LoadingView

    lateinit var mPresenter: ComicPresenter
    lateinit var mCharactersAdapter: ComicAdapter


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v: View = inflater!!.inflate(R.layout.fragment_comic, container, false)

        ButterKnife.bind(this, v)

        loadinf.configureLoading()


        mCharactersAdapter = ComicAdapter(context, R.layout.comic_item)
        mCharactersView.adapter = mCharactersAdapter


        return v
    }


    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)

        mPresenter = ComicPresenter()
        mPresenter.attachView(this)


    }

    override fun onStart() {
        super.onStart()
        mPresenter.start()
        if (!finish) {
            mPresenter.loadCharacters()
        }
    }

    override fun onStop() {
        super.onStop()
        mPresenter.stop()

    }

    override fun onScrollIsEnding() {
        if (!finish) {
            mPresenter.loadCharacters()
        }
    }

    override fun showLoading() {
        mProgressView.visibility = View.VISIBLE
        loadinf.startAnimation()
    }

    override fun hideLoading() {
        mProgressView.visibility = View.GONE
    }

    override fun onGetComicsSuccess(data: ArrayList<Comic>) {

        mCharactersAdapter.addData(data = data)

    }

    override fun setMaxData(count: Int) {

        finish = mCharactersAdapter.count == count
    }


    override fun onError(error: String) {
        showMessage(error)
    }


    private fun showMessage(message: String) {
        Toast.makeText(context, message, android.widget.Toast.LENGTH_SHORT).show()

    }
}
