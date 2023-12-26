package com.example.demomvvm.ui.activityTest.secondFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.demomvvm.R
import com.example.demomvvm.databinding.FragmentSecondBinding
import com.example.demomvvm.ui.base.mvvm.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
@AndroidEntryPoint
class SecondFragment : BaseFragment<FragmentSecondBinding, SecondFragmentViewModel>() {
    override fun getViewBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentSecondBinding.inflate(inflater, container, false)

    override fun getViewModelClass() = SecondFragmentViewModel::class.java

    override fun init() {
        viewModel.showMessage.observe(this) { message ->
            showToast(message)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding!!.buttonTest.setOnClickListener {
            viewModel.showMessage("Hello Fragment 2!")
        }

        binding!!.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
