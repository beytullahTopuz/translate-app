package com.t4zb.gboytranslate.core.modellayer.rest.service.repo

import android.app.Application
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import com.t4zb.gboytranslate.core.modellayer.rest.service.api.PostTranslateAPI
import com.t4zb.gboytranslate.core.modellayer.rest.service.event.ResultModel
import com.t4zb.gboytranslate.core.modellayer.rest.service.event.TextModel
import com.t4zb.gboytranslate.core.modellayer.rest.service.request.RetrofitClientInstance
import com.t4zb.gboytranslate.utils.showLogDebug
import com.t4zb.gboytranslate.utils.showLogError
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class TranslateRepository(var app: Application, var traslateModel: TextModel) {
    val resultData = MutableLiveData<ResultModel>()
    @WorkerThread
    fun callWebServiceTranslate() {
        val retrofit = RetrofitClientInstance().buildRetrofit(app.applicationContext)
        val service = retrofit!!.create(PostTranslateAPI::class.java)
        val call = service.postTranslateService(traslateModel)
        call.enqueue(object :
            Callback<ResultModel> {
            override fun onResponse(call: Call<ResultModel>, response: Response<ResultModel>) {
                if (response.isSuccessful){
                    showLogDebug(TAG,response.body().toString())
                    resultData.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<ResultModel>, t: Throwable) {
                showLogError(TAG, t.printStackTrace().toString())
            }
        }
        )
    }
    init {
        CoroutineScope(Dispatchers.IO).launch {
            callWebServiceTranslate()
        }
    }
    companion object {
        const val TAG = "TRANSLATEREPOSITORY";
    }

}