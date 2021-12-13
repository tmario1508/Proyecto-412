package com.mariotorrese.proyecto_412.data.remote

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.mariotorrese.proyecto_412.app.Constants


object ApiClient {
    val service by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.UrlBase)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(apiservice::class.java)
    }
}