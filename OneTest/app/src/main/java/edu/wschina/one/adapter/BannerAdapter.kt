package edu.wschina.one.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import edu.wschina.one.R

class BannerAdapter(val list: List<Int>) : RecyclerView.Adapter<BaseHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.banenr_item_view, parent, false)
        return BaseHolder(view)
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        holder.itemView as ImageView
        holder.itemView.setImageResource(list[position])
    }

    override fun getItemCount(): Int = list.size
}