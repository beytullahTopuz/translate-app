package com.t4zb.gboytranslate.core.modellayer.rest.service.api

import com.t4zb.gboytranslate.core.modellayer.rest.service.event.ResultModel
import com.t4zb.gboytranslate.core.modellayer.rest.service.event.TextModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface PostTranslateAPI {

    @Headers("Content-Type: application/json")
    @POST("ceviri/my-resource")
    fun postTranslateService(@Body requestBody: TextModel): Call<ResultModel>
}