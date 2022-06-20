package edu.wschina.one.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.wschina.one.R
import edu.wschina.one.activity.DetailActivity

class MainRevAdapter(val num: Int) : RecyclerView.Adapter<BaseHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.info_item_view, parent, false)
        return BaseHolder(view)
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        holder.itemView.setOnClickListener {
            holder.itemView.context.startActivity(
                Intent(
                    holder.itemView.context,
                    DetailActivity::class.java
                )
            )
        }
    }

    override fun getItemCount(): Int = num
}