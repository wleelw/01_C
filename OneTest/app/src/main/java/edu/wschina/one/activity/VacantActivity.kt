package edu.wschina.one.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import edu.wschina.one.adapter.MainRevAdapter
import edu.wschina.one.databinding.ActivityVacantBinding

class VacantActivity : AppCompatActivity() {
    private lateinit var binding: ActivityVacantBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVacantBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.Rev.adapter = MainRevAdapter(10)
        binding.Rev.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        binding.backButton.setOnClickListener { finish() }
    }
}