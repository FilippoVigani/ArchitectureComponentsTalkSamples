package com.example.acts.collect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.navigation.fragment.navArgs
import com.example.acts.databinding.FragmentCollectBinding

class CollectFragment : Fragment() {

    private lateinit var binding: FragmentCollectBinding
    private val viewModel by viewModels<CollectViewModel> {
        SavedStateViewModelFactory(requireActivity().application, this)
    }

    val args by navArgs<CollectFragmentArgs>()

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

        viewModel.setCount(args.count)

        return binding.root
    }
}