package testkotlin.com.mykotlinapplication.presenter

import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import roberto.com.retrofitapisample.models.Comic
import roberto.com.retrofitapisample.models.ComicDataWrapper
import testkotlin.com.mykotlinapplication.domain.ComicController

/**
 * Created by robertomiranda on 18/5/17.
 */

class ComicPresenter : BasePresenter<ComicPresenter.ComicContrac>() {


    private var offset: Int = 0
    private var limit: Int = 20


    fun loadCharacters() {
        mView?.showLoading()
        ComicController.getInstance(mView?.getContext()!!).getAvengers(offset)

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onGetAllcharactersSuceess(characters: ComicDataWrapper) {
        mView?.hideLoading()
        mView?.onGetComicsSuccess(ArrayList(characters.data!!.results!!))
        mView?.setMaxData(characters.data!!.total);
        offset += limit

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onGetAllcharactersError(error: String) {
        mView?.hideLoading()
        mView?.onError(error)
    }


    interface ComicContrac : BasePresenter.BaseContract {


        fun onGetComicsSuccess(data: ArrayList<Comic>)

    }
}
