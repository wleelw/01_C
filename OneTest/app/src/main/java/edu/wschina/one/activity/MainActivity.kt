package edu.wschina.one.activity

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import edu.wschina.one.R
import edu.wschina.one.adapter.MainAdapter
import edu.wschina.one.databinding.ActivityMainBinding
import edu.wschina.one.fragment.AssetsFragment
import edu.wschina.one.fragment.FrontFragment
import edu.wschina.one.fragment.MineFragment
import edu.wschina.one.fragment.NewsFragment

class MainActivity : AppCompatActivity() {
    companion object {
        val list =
            arrayListOf<Fragment>(FrontFragment(), AssetsFragment(), NewsFragment(), MineFragment())
    }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

    }


    /**
     * 加载视图
     */
    private fun initView() {
        // 加载底部导航栏
        changeImg(binding.radioButton1, R.drawable.main_nav_1, 80, 120)
        changeImg(binding.radioButton2, R.drawable.main_nav_2, 140, 120)
        changeImg(binding.radioButton3, R.drawable.main_nav_3, 80, 120)
        changeImg(binding.radioButton4, R.drawable.main_nav_4, 80, 120)

        binding.mainContent.adapter = MainAdapter(list, this)

        // 切换页面监听
        binding.mainContent.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> binding.radioButton1.isChecked = true
                    1 -> binding.radioButton2.isChecked = true
                    2 -> binding.radioButton3.isChecked = true
                    3 -> binding.radioButton4.isChecked = true
                }
            }
        })

        // 点击底部导航栏切换
        binding.radioButton1.setOnClickListener { binding.mainContent.currentItem = 0 }
        binding.radioButton2.setOnClickListener { binding.mainContent.currentItem = 1 }
        binding.radioButton3.setOnClickListener { binding.mainContent.currentItem = 2 }
        binding.radioButton4.setOnClickListener { binding.mainContent.currentItem = 3 }

        // 禁止用户进行滑动
        binding.mainContent.isUserInputEnabled = false
    }

    /**
     * 修改图片大小
     */
    private fun changeImg(radioButton: RadioButton, imgId: Int, w: Int, h: Int) {
        val img = resources.getDrawable(imgId).apply {
            setBounds(0, 0, w, h)
        }
        radioButton.setCompoundDrawables(null, img, null, null)
    }
}