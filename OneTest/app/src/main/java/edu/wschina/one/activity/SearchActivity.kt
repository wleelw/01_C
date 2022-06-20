package edu.wschina.one.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.wschina.one.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        intent.getStringExtra("info").let {
            if (it == "") return@let
            binding.searchText.setText(it)
        }
        binding.backButton.setOnClickListener { finish() }
        binding.cancelButton.setOnClickListener { finish() }
    }
}