package edu.wschina.one.fragment

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.viewpager2.widget.ViewPager2
import edu.wschina.one.R
import edu.wschina.one.activity.ReleaseActivity
import edu.wschina.one.activity.SearchActivity
import edu.wschina.one.activity.VacantActivity
import edu.wschina.one.adapter.BannerAdapter
import edu.wschina.one.adapter.MainRevAdapter
import edu.wschina.one.databinding.FragmentFrontBinding

class FrontFragment : Fragment() {
    companion object {
        val listBanner = arrayListOf(
            R.drawable.banner,
            R.drawable.banner,
            R.drawable.banner,
            R.drawable.banner,
            R.drawable.banner,
        )
    }

    private lateinit var binding: FragmentFrontBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFrontBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.mainBanner.adapter = BannerAdapter(listBanner)
        binding.mainBanner.postDelayed(mLooper, 2000)

        binding.mainBanner.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                changeRadio(position)
            }
        })

        binding.mainRev.adapter = MainRevAdapter(3)
        binding.mainRev.addItemDecoration(
            DividerItemDecoration(
                activity,
                DividerItemDecoration.VERTICAL
            )
        )

        binding.openRelease.setOnClickListener {
            val intent = Intent(activity, ReleaseActivity::class.java)
            startActivity(intent)
        }

        // 跳转到搜索界面
        binding.searchBtn.setOnClickListener {
            if (binding.searchText.text.toString().isNotEmpty()) {
                val intent = Intent(activity, SearchActivity::class.java)
                intent.putExtra("info", binding.searchText.text.toString())
                startActivity(intent)
            } else {
                Toast.makeText(activity, "请先输入你想查询的内容", Toast.LENGTH_SHORT).show()
            }
        }

        // 跳转到闲置房屋界面
        binding.vacantBtn.setOnClickListener {
            startActivity(Intent(activity, VacantActivity::class.java))
        }
    }

    /**
     * 切换轮播图的点
     */
    private fun changeRadio(itemId: Int) {
        binding.bannerOne.setBackgroundColor(Color.parseColor("#EEEEEE"))
        binding.bannerTwo.setBackgroundColor(Color.parseColor("#EEEEEE"))
        binding.bannerThree.setBackgroundColor(Color.parseColor("#EEEEEE"))
        binding.bannerFour.setBackgroundColor(Color.parseColor("#EEEEEE"))
        binding.bannerFive.setBackgroundColor(Color.parseColor("#EEEEEE"))
        when (itemId) {
            0 -> binding.bannerOne.setBackgroundColor(Color.parseColor("#BBBBBB"))
            1 -> binding.bannerTwo.setBackgroundColor(Color.parseColor("#BBBBBB"))
            2 -> binding.bannerThree.setBackgroundColor(Color.parseColor("#BBBBBB"))
            3 -> binding.bannerFour.setBackgroundColor(Color.parseColor("#BBBBBB"))
            4 -> binding.bannerFive.setBackgroundColor(Color.parseColor("#BBBBBB"))
        }
    }

    // 自动轮播
    private val mLooper = object : Runnable {
        override fun run() {
            if (binding.mainBanner.currentItem < listBanner.size - 1) {
                binding.mainBanner.currentItem++
                binding.mainBanner.postDelayed(this, 2000)
                changeRadio(binding.mainBanner.currentItem)
            } else {
                binding.mainBanner.currentItem = 0
                binding.mainBanner.postDelayed(this, 2000)
                changeRadio(binding.mainBanner.currentItem)
            }
        }
    }
}