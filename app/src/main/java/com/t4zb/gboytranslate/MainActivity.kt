package com.t4zb.gboytranslate

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.t4zb.gboytranslate.core.modellayer.rest.service.event.TextModel
import com.t4zb.gboytranslate.core.modellayer.rest.service.repo.TranslateRepository

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()



    }
}