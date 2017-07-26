package testkotlin.com.mykotlinapplication.view.fragments;

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import io.saeid.fabloading.LoadingView
import roberto.com.retrofitapisample.models.Character
import testkotlin.com.mykotlinapplication.R
import testkotlin.com.mykotlinapplication.extensions.configureLoading
import testkotlin.com.mykotlinapplication.presenter.CharactersPresenter
import testkotlin.com.mykotlinapplication.routing.AppNavigation
import testkotlin.com.mykotlinapplication.view.activity.DetailActivity
import testkotlin.com.mykotlinapplication.view.adapters.CharactersAdapter
import testkotlin.com.mykotlinapplication.viewmodels.CharacterVM


class CharactersFragment : Fragment(), CharactersPresenter.CharactersViewContract, CharactersAdapter.CharactersListCallBack {
    private var finish: Boolean = false


    @BindView(R.id.loading_view)
    lateinit var mProgressView: RelativeLayout
    @BindView(R.id.characters_list)
    lateinit var mCharactersView: RecyclerView
    @BindView(R.id.progress_view)
    lateinit var loadinf: LoadingView


    lateinit var mPresenter: testkotlin.com.mykotlinapplication.presenter.CharactersPresenter
    lateinit var mCharactersAdapter: CharactersAdapter


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v: View = inflater!!.inflate(R.layout.fragment_characters, container, false)

        ButterKnife.bind(this, v)

        loadinf.configureLoading()


        mCharactersAdapter = CharactersAdapter(context, R.layout.character_row, this) {navigateTo(it)}
        mCharactersView.layoutManager = LinearLayoutManager(context)
        mCharactersView.adapter = mCharactersAdapter


        return v
    }



    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)

        mPresenter = testkotlin.com.mykotlinapplication.presenter.CharactersPresenter()
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

    override fun onGetCharactersSuccess(data: ArrayList<Character>) {

        mCharactersAdapter.addData(data = data)

    }

    override fun setMaxData(count: Int) {

        finish = mCharactersAdapter.itemCount == count;
    }


    override fun onError(error: String) {
        showMessage(error)
    }


    private fun showMessage(message: String) {
        Toast.makeText(context, message, android.widget.Toast.LENGTH_SHORT).show()

    }

    private fun navigateTo(viewmodel : CharacterVM) {
        AppNavigation.navigateToDetailActivity(this!!.activity, viewmodel)
    }
}
