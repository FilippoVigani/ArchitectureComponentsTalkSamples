package com.example.acts.collect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.example.acts.collect.data.MeeseeksAdapter
import com.example.acts.databinding.FragmentCollectBinding

class CollectFragment : Fragment() {

    private lateinit var binding: FragmentCollectBinding
    private val viewModel by viewModels<CollectViewModel> {
        ViewModelProvider.AndroidViewModelFactory(requireActivity().application)
    }

    private val args by navArgs<CollectFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCollectBinding.inflate(inflater, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner
                viewModel = this@CollectFragment.viewModel
            }

        binding.meeseeksList.apply {
            val meeseeksAdapter = MeeseeksAdapter()

            adapter = meeseeksAdapter

            viewModel.meeseeks.observe(viewLifecycleOwner) {
                meeseeksAdapter.submitList(it)
            }
        }

        binding.meeseeksSwipeRefreshLayout.apply {
            isEnabled = false
        }

        viewModel.setCount(args.count)

        return binding.root
    }
}