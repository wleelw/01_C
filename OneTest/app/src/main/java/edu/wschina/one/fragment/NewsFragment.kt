package edu.wschina.one.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.wschina.one.adapter.NewsAdapter
import edu.wschina.one.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {
    private lateinit var binding: FragmentNewsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val list = arrayListOf(
            NewsAdapter.TYPE.TYPE_ONE,
            NewsAdapter.TYPE.TYPE_TWO,
            NewsAdapter.TYPE.TYPE_ONE,
            NewsAdapter.TYPE.TYPE_TWO,
            NewsAdapter.TYPE.TYPE_ONE,
            NewsAdapter.TYPE.TYPE_TWO,
            NewsAdapter.TYPE.TYPE_ONE,
            NewsAdapter.TYPE.TYPE_TWO,
            NewsAdapter.TYPE.TYPE_ONE,
            NewsAdapter.TYPE.TYPE_TWO,
            NewsAdapter.TYPE.TYPE_ONE,
            NewsAdapter.TYPE.TYPE_TWO,
            NewsAdapter.TYPE.TYPE_ONE,
            NewsAdapter.TYPE.TYPE_TWO,
            NewsAdapter.TYPE.TYPE_ONE
        )
        binding.newsRev.adapter = NewsAdapter(list)
    }
}