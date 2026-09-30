package com.pemob.cattlevya.network

import com.pemob.cattlevya.data.model.Category
import com.pemob.cattlevya.data.model.Product
import com.pemob.cattlevya.util.JualanConstants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET(value = "data/categories.json")
    suspend fun getCategories(): List<Category>

    @GET(value = "data/products.json")
    suspend fun getProducts(): List<Product>
}

object ApiClient {
    val instance: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}
