package com.example.demomvvm.ui.activityTest

import android.os.Bundle
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.demomvvm.R
import com.example.demomvvm.databinding.ActivityTestBinding
import com.example.demomvvm.ui.base.mvvm.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityTest : BaseActivity<ActivityTestBinding, ActivityTestViewModel>() {
    override fun getViewBinding() = ActivityTestBinding.inflate(layoutInflater)
    override fun getViewModelClass() = ActivityTestViewModel::class.java
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun init() {
        viewModel.showMessage.observe(this) { message ->
            showToast(message)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_activity_test)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener {
            viewModel.showMessage("Hello Activity!")
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_activity_test)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
