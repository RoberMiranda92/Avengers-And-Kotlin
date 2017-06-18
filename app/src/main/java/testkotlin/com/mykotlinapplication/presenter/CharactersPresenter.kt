package testkotlin.com.mykotlinapplication.presenter

import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import roberto.com.retrofitapisample.models.Character
import roberto.com.retrofitapisample.models.CharacterDataWrapper
import testkotlin.com.mykotlinapplication.domain.CharacterController

/**
 * Created by robertomiranda on 18/5/17.
 */

class CharactersPresenter : BasePresenter<CharactersPresenter.CharactersViewContract>() {


    private var offset: Int = 0
    private var limit: Int = 20


    fun loadCharacters() {

        mView?.showLoading()
        CharacterController.getInstance(mView?.getContext()!!).getAvengers(offset)

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onGetAllcharactersSuceess(characters: CharacterDataWrapper) {
        mView?.hideLoading()
        mView?.onGetCharactersSuccess(ArrayList(characters.data!!.results!!))
        mView?.setMaxData(characters.data!!.total);
        offset += limit

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onGetAllcharactersError(error: String) {
        mView?.hideLoading()
        mView?.onError(error)
    }


    interface CharactersViewContract : BaseContract {


        fun onGetCharactersSuccess(data: ArrayList<Character>)

    }
}
