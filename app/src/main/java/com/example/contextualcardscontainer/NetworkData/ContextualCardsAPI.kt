package com.example.contextualcardscontainer.NetworkData

import retrofit2.Response
import retrofit2.http.GET

interface ContextualCardsAPI {

    @GET("/v3/fefcfbeb-5c12-4722-94ad-b8f92caad1ad")
    suspend fun getContextualCards() : Response<ContextualCardsResponse>

}