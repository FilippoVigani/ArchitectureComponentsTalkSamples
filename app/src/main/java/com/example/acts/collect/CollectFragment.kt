package com.example.acts.collect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateViewModelFactory
import com.example.acts.databinding.FragmentCollectBinding

class CollectFragment : Fragment() {

    private lateinit var binding: FragmentCollectBinding
    private val viewModel by viewModels<CollectViewModel> {
        SavedStateViewModelFactory(requireActivity().application, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentCollectBinding.inflate(inflater, container, false)
            .apply {
                binding = this
                lifecycleOwner = viewLifecycleOwner
                viewModel = this@CollectFragment.viewModel
            }.root
    }
}