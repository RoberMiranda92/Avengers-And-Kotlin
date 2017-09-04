package testkotlin.com.mykotlinapplication.view.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import roberto.com.retrofitapisample.models.Character
import testkotlin.com.mykotlinapplication.R
import testkotlin.com.mykotlinapplication.view.CharacterView
import testkotlin.com.mykotlinapplication.viewmodels.CharacterVM

/**
 * Created by RobertoMiranda on 11/06/2017.
 */
class CharactersAdapter(val context: Context, val layoutID: Int, val callback: CharactersListCallBack?, val listener: (CharacterVM) -> Unit) : RecyclerView.Adapter<CharactersAdapter.CharacterViewHolder>() {

    private var data: ArrayList<Character>? = null
    private var mRowViewId = layoutID


    init {
        data = ArrayList()
        mRowViewId = layoutID
    }


    override fun getItemCount(): Int {
        return data!!.size
    }


    fun setData(data: ArrayList<Character>) {

        this.data = data
        this.notifyDataSetChanged()

    }

    override fun onBindViewHolder(holder: CharacterViewHolder?, position: Int) {


        val character: Character = data!!.get(position)

        (holder!! as CharacterViewHolder).bind(character)

        if (position == data!!.size - 5) {

            callback?.onScrollIsEnding()
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CharacterViewHolder {


        var view: View = LayoutInflater.from(context).inflate(mRowViewId, parent, false)


        return CharacterViewHolder(view, listener)
    }

    interface CharactersListCallBack {

        fun onScrollIsEnding()
    }

    fun addData(data: ArrayList<Character>) {
        this.data?.addAll(data)
        notifyDataSetChanged()
    }

    /**
     *
     */
    class CharacterViewHolder constructor(itemView: View?, val listener : (CharacterVM) -> Unit) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.characters_item)
        lateinit var mCharacterView: CharacterView

        init {
            ButterKnife.bind(this, itemView!!)
        }

        fun bind(data : Character) {
            (this.itemView as CharacterView).setCharacter(data)

            this.itemView.setOnClickListener { listener(CharacterVM(itemView, data)) }
        }

    }
}