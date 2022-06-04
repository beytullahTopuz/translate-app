package com.t4zb.gboytranslate.ui.Contract

class BaseContract {
    interface ViewMain {
        fun setupViewModel()
        fun initializeViews()
    }

    interface PresenterMain {
        fun onViewsCreated()
    }
}