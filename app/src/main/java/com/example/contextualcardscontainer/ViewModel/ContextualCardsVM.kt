package com.example.contextualcardscontainer.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contextualcardscontainer.NetworkData.ContextualCardsResponse
import com.example.contextualcardscontainer.Repo.ContextualCardsRepository
import com.example.contextualcardscontainer.NetworkData.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class ContextualCardsVM(private val contextualCardsRepository: ContextualCardsRepository) : ViewModel() {

    val contextualCards : MutableLiveData<Resource<ContextualCardsResponse>> = MutableLiveData()

    init {
        getContextualCards()
    }

    fun getContextualCards() = viewModelScope.launch {
        contextualCards.postValue(Resource.Loading())
        val response = contextualCardsRepository.getContextualCards()
        contextualCards.postValue(handleContextualCardsResponse(response))
    }

    private fun handleContextualCardsResponse(response: Response<ContextualCardsResponse>) :
            Resource<ContextualCardsResponse> {
        if(response.isSuccessful) {
            response.body()?.let { result ->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

}