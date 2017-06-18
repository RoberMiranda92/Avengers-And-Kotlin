package testkotlin.com.mykotlinapplication.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import roberto.com.retrofitapisample.models.Comic
import testkotlin.com.mykotlinapplication.view.ComicView

/**
 * Created by RobertoMiranda on 17/06/2017.
 */
class ComicAdapter(context: Context, layoutID: Int) : BaseAdapter() {


    private var data: ArrayList<Comic>? = null
    private var mContext = context
    private var mRowViewId = layoutID
//    private var mCallback: CharactersListCallBack? = callback;

    init {
        data = ArrayList()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val inflate: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val comicView: ComicView = inflate.inflate(mRowViewId, parent, false) as ComicView


        comicView.setComic(data!!.get(position));


        return comicView
    }

    override fun getItem(position: Int): Any {

        return data!!.get(position)

    }

    override fun getItemId(position: Int): Long {
        return 0;
    }

    override fun getCount(): Int {
        return data!!.size
    }

    fun addData(data: ArrayList<Comic>) {
        this.data!!.addAll(data)
        notifyDataSetChanged()
    }


}