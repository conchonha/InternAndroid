package com.example.taskdeha.ui.language

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.taskdeha.R
import com.example.taskdeha.base.BaseFragment
import com.example.taskdeha.databinding.FragmentLanguageBinding
import com.example.taskdeha.ui.adapter.LanguageAdapter
import com.example.taskdeha.utils.Const.getListLanguage
import com.example.taskdeha.utils.CustomDialog


class FragmentLanguage : BaseFragment<FragmentLanguageBinding, LanguageViewModel>() {
    override val layoutId: Int = R.layout.fragment_language
    var dialog = CustomDialog()

    override val viewModel: LanguageViewModel by viewModels()
    private val   adapter by lazy { LanguageAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listLanguage = getListLanguage(resources)
        adapter.setData(listLanguage)

        with(binding) {
            recyclerviewLanguage.adapter = adapter
            ivSelect.setOnClickListener {
                viewModel.changeLanguage()
            }
        }
        adapter.setOnItemClickListener(viewModel)
    }
}


