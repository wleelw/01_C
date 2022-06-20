package edu.wschina.one.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.wschina.one.databinding.FragmentAssetsBinding

class AssetsFragment : Fragment() {
    private lateinit var binding: FragmentAssetsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAssetsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.one.setOnClickListener {
            binding.messageShow.visibility = View.VISIBLE
        }
        binding.two.setOnClickListener {
            binding.messageShow.visibility = View.VISIBLE
        }
        binding.three.setOnClickListener {
            binding.messageShow.visibility = View.VISIBLE
        }
        // 拦截不必要的点击
        binding.messageShow.setOnClickListener {
            return@setOnClickListener
        }
        binding.map.setOnClickListener {
            binding.messageShow.visibility = View.GONE
        }
    }
}