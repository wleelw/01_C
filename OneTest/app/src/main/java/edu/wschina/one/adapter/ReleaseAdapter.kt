package edu.wschina.one.adapter

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import edu.wschina.one.R
import edu.wschina.one.activity.DetailActivity
import edu.wschina.one.dto.ReleaseInfo

class ReleaseAdapter(private val list: MutableList<ReleaseInfo>) :
    RecyclerView.Adapter<BaseHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.detail_item_view, parent, false)
        return BaseHolder(view)
    }

    var startX = 0f
    var endX = 0f

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {

        val del = holder.itemView.findViewById<TextView>(R.id.del)
        del.tag = list[position]
        val content = holder.itemView.findViewById<LinearLayout>(R.id.content)

        del.setOnClickListener {
            list.remove(del.tag)
            content.x = 0f
            del.x = holder.itemView.width + 0f
            notifyDataSetChanged()
        }


        holder.itemView.setOnTouchListener { v, event ->
            if (event == null) true
            when (event.action) {
                MotionEvent.ACTION_MOVE -> {
                    endX = event.x
                }
                MotionEvent.ACTION_UP -> {
                    val animator = AnimatorSet()
                    animator.duration = 500
                    if (startX > endX && holder.itemView.x == content.x) {
                        Toast.makeText(holder.itemView.context, "我左滑了", Toast.LENGTH_SHORT)
                            .show()
                        val animatorContent =
                            ObjectAnimator.ofFloat(content, "x", 0f, -del.width + 0f)
                        val animatorDel =
                            ObjectAnimator.ofFloat(
                                del,
                                "x",
                                1080f,
                                1080f - del.width
                            )
                        animator.playTogether(animatorContent, animatorDel)
                        animator.start()
                        del.x = del.x - del.width
                        content.x = content.x - del.width
                    } else if (startX < endX && holder.itemView.x != content.x) {
                        Toast.makeText(holder.itemView.context, "我右滑了", Toast.LENGTH_SHORT)
                            .show()
                        val animatorContent =
                            ObjectAnimator.ofFloat(
                                content,
                                "x",
                                content.x + 0f,
                                content.x + 0f + del.width
                            )
                        val animatorDel =
                            ObjectAnimator.ofFloat(
                                del,
                                "x",
                                del.x + 0f,
                                del.x + del.width + 0f
                            )
                        animator.playTogether(animatorContent, animatorDel)
                        animator.start()
                        content.x = content.x - del.width
                        del.x = del.x - del.width
                    } else {
                        holder.itemView.context.startActivity(
                            Intent(
                                holder.itemView.context,
                                DetailActivity::class.java
                            )
                        )
                        val animatorContent =
                            ObjectAnimator.ofFloat(
                                content,
                                "x",
                                content.x + 0f,
                                content.x + 0f + del.width
                            )
                        val animatorDel =
                            ObjectAnimator.ofFloat(
                                del,
                                "x",
                                del.x + 0f,
                                del.x + del.width + 0f
                            )
                        animator.playTogether(animatorContent, animatorDel)
                        animator.start()
                        content.x = content.x - del.width
                        del.x = del.x - del.width
                    }
                }
                MotionEvent.ACTION_DOWN -> {
                    startX = event.x
                }
            }
            true
        }

        if (list[position].isRelease) {
            holder.itemView.findViewById<TextView>(R.id.showbutton).apply {
                text = "已发布"
                setTextColor(Color.parseColor("#3882F8"))
            }
            holder.itemView.findViewById<LinearLayout>(R.id.buttons).visibility = View.GONE
        } else {
            if (list[position].isChange) {
                holder.itemView.findViewById<MaterialButton>(R.id.change).visibility = View.GONE
            }
        }
//        holder.itemView.findViewById<LinearLayout>(R.id.detail_open).setOnClickListener {
//            holder.itemView.context.startActivity(
//                Intent(
//                    holder.itemView.context,
//                    DetailActivity::class.java
//                )
//            )
//        }

    }

    override fun getItemCount(): Int = list.size
}