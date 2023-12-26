package com.example.taskdeha.ui.image

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taskdeha.R

class FragmentImage : Fragment() {

    companion object {
        fun newInstance() = FragmentImage()
    }

    private lateinit var viewModel: FragmentImageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragmentImageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}