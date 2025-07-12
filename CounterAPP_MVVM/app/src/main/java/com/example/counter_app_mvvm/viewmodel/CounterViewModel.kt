package com.example.counter_app_mvvm.viewmodel

import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {

    var counter = 0

    fun getInitialCount():Int{
        return counter
    }
    fun getUpdatedCount(): Int{
        return ++counter
    }
}