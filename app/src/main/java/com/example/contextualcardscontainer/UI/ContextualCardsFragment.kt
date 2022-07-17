package com.example.contextualcardscontainer.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.contextualcardscontainer.ViewModel.ContextualCardsVM
import com.example.contextualcardscontainer.R
import com.example.contextualcardscontainer.NetworkData.Resource
import com.example.contextualcardscontainer.databinding.FragmentContextualCardsBinding
import kotlinx.android.synthetic.main.layout_error_empty_state.view.*

class ContextualCardsFragment : Fragment() {
    lateinit var viewModel: ViewModel
    private lateinit var binding : FragmentContextualCardsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_contextual_cards, container, false)
        viewModel = (activity as MainActivity).viewModel
        initBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun initBinding() {
        binding.lifecycleOwner = this
        binding.viewModel = viewModel as ContextualCardsVM?
    }

    private fun init() {
        initApiObservers()
        binding.swipeRefresh.setOnRefreshListener {
            initTasks()
        }
    }

    private fun initTasks() {
        (viewModel as ContextualCardsVM).getContextualCards()
    }

    private fun initApiObservers() {
        (viewModel as ContextualCardsVM).contextualCards.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    stopLoadingProgress()
                    response.data?.let {
                        TODO("Not able to implement due to time constraint")
                    }
                }

                is Resource.Error -> {
                    stopLoadingProgress()
                    binding.connectionErrorState.visibility = View.VISIBLE
                    binding.connectionErrorState.retryBtn.setOnClickListener {
                        initTasks()
                    }
                }

                is Resource.Loading -> {
                    binding.LoadingInProgress.visibility = View.VISIBLE
                }
            }
        }
    }

    private fun stopLoadingProgress() {
        binding.LoadingInProgress.visibility = View.GONE
        binding.swipeRefresh.isRefreshing = false
    }

}