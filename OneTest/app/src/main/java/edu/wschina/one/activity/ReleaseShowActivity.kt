package edu.wschina.one.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.wschina.one.adapter.ReleaseAdapter
import edu.wschina.one.databinding.ActivityReleaseShowBinding
import edu.wschina.one.dto.ReleaseInfo

class ReleaseShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReleaseShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReleaseShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener { finish() }
        val list = arrayListOf(
            ReleaseInfo(isChange = true, isRelease = false),
            ReleaseInfo(isChange = false, isRelease = true),
            ReleaseInfo(isChange = false, isRelease = false),
            ReleaseInfo(isChange = false, isRelease = false),
        )
        binding.Rev.adapter = ReleaseAdapter(list)
    }
}