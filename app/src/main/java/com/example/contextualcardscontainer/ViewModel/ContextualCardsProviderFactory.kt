package com.example.contextualcardscontainer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.contextualcardscontainer.Repo.ContextualCardsRepository
import com.example.contextualcardscontainer.ViewModel.ContextualCardsVM

class ContextualCardsVMProviderFactory(
    val contextualCardsRepository: ContextualCardsRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ContextualCardsVM(contextualCardsRepository) as T
    }
}