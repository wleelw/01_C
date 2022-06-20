package edu.wschina.one.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.wschina.one.databinding.ActivityReleaseBinding

class ReleaseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReleaseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReleaseBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bg.setOnClickListener {
            finish()
        }
        binding.releaseBtns.setOnClickListener { return@setOnClickListener }
    }
}