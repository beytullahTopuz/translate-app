package com.t4zb.gboytranslate.core.modellayer.rest.service.request

import android.content.Context
import com.t4zb.gboytranslate.core.modellayer.network.Cache.CacheClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientInstance {
    private var retrofit: Retrofit? = null

    fun buildRetrofit(context: Context): Retrofit? {
        val client = CacheClient.createCachedClient(context)
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl("https://qvbnhsy5h0.execute-api.us-east-1.amazonaws.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}