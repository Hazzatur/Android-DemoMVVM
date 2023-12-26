package com.example.demomvvm.ui.activityTest.secondFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.demomvvm.ui.base.mvvm.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondFragmentViewModel @Inject constructor() : BaseViewModel() {
    private val showMessageLiveData = MutableLiveData<String>()

    val showMessage: LiveData<String>
        get() = showMessageLiveData

    fun showMessage(message: String) {
        showMessageLiveData.value = message
    }
}