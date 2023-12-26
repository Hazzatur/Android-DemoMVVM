package com.example.demomvvm.ui.activityTest.firstFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.demomvvm.R
import com.example.demomvvm.databinding.FragmentFirstBinding
import com.example.demomvvm.ui.base.mvvm.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class FirstFragment : BaseFragment<FragmentFirstBinding, FirstFragmentViewModel>() {
    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentFirstBinding.inflate(inflater, container, false)

    override fun getViewModelClass() = FirstFragmentViewModel::class.java

    override fun init() {
        viewModel.showMessage.observe(this) { message ->
            showToast(message)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.buttonTest.setOnClickListener {
            viewModel.showMessage("Hello Fragment 1!")
        }

        binding!!.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
