package edu.wschina.one.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.wschina.one.R
import edu.wschina.one.activity.ReleaseShowActivity
import edu.wschina.one.databinding.FragmentMineBinding

class MineFragment : Fragment() {
    private lateinit var binding: FragmentMineBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnMy.setOnClickListener {
            startActivity(Intent(activity, ReleaseShowActivity::class.java))
        }
    }
}