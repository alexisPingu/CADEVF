package com.beyondthecode.cade.api.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClientt {

    private var retrofit: Retrofit? = null
    private const val BASE_UR = "http://192.168.1.70:8081"
    private const val BASE_URL = "http://ec2-18-220-30-62.us-east-2.compute.amazonaws.com:8081"

    fun getRetrofitInstance(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }

}
