package edu.wschina.one.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.wschina.one.adapter.MainRevAdapter
import edu.wschina.one.databinding.ActivityDetialBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetialBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Rev.adapter = MainRevAdapter(3)
        binding.backButton.setOnClickListener {
            finish()
        }
    }
}