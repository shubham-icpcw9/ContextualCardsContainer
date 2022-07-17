package com.example.contextualcardscontainer.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.contextualcardscontainer.Repo.ContextualCardsRepository
import com.example.contextualcardscontainer.ViewModel.ContextualCardsVM
import com.example.contextualcardscontainer.ContextualCardsVMProviderFactory
import com.example.contextualcardscontainer.R

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ContextualCardsVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contextualCardsRepository = ContextualCardsRepository()
        val viewModelProviderFactory = ContextualCardsVMProviderFactory(contextualCardsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[ContextualCardsVM::class.java]
    }
}