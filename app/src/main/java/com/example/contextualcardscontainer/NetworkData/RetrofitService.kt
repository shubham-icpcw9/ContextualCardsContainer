package com.example.contextualcardscontainer.NetworkData

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
    companion object {
        var BASE_URL = "https://run.mocky.io"

        private val retrofit by lazy {
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        }

        val retrofitApi by lazy {
            retrofit.create(ContextualCardsAPI::class.java)
        }
    }
}