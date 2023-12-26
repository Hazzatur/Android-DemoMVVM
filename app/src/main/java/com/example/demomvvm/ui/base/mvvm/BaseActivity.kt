package com.example.demomvvm.ui.base.mvvm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : AppCompatActivity() {
    protected lateinit var binding: VB
    protected lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[getViewModelClass()]
        init()
    }

    abstract fun getViewBinding(): VB
    abstract fun getViewModelClass(): Class<VM>
    abstract fun init()
}
