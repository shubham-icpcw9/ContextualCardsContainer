package com.example.contextualcardscontainer.Repo

import com.example.contextualcardscontainer.NetworkData.RetrofitService

class ContextualCardsRepository {

    suspend fun getContextualCards() = RetrofitService.retrofitApi.getContextualCards()
}