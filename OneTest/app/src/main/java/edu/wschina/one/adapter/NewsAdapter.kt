package edu.wschina.one.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.wschina.one.R

class NewsAdapter(val list: List<TYPE>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    enum class TYPE(val type: Int) {
        TYPE_ONE(1),
        TYPE_TWO(2),
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            TYPE.TYPE_ONE.type -> return BaseHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.news_item_view_type_one, parent, false)
            )
            else -> return BaseHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.news_item_view_type_two, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = list.size

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }
}