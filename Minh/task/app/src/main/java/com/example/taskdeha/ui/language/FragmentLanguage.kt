package com.example.taskdeha.ui.language


import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.taskdeha.R
import com.example.taskdeha.base.BaseFragment
import com.example.taskdeha.data.model.Language
import com.example.taskdeha.databinding.FragmentLanguageBinding
import com.example.taskdeha.ui.adapter.LanguageAdapter


class FragmentLanguage : BaseFragment<FragmentLanguageBinding, LanguageViewModel>() {
    override val layoutId: Int = R.layout.fragment_language
    private lateinit var adapter: LanguageAdapter
    override fun onInternetChange(isNetWork: Boolean) {
        TODO("Not yet implemented")
    }

    override val viewModel: LanguageViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = LanguageAdapter()
        val listLanguage = listOf<Language>(
            Language(
                "C:\\Users\\MinhNN\\Downloads\\Flag_of_the_United_Kingdom_(1-2).png",
                resources.getString(R.string.language_english)
            ),
            Language("sfsd", resources.getString(R.string.language_spain)),
            Language("sfsd", resources.getString(R.string.language_portugal)),
            Language("sfsd", resources.getString(R.string.language_hindi)),
            Language("sfsd", resources.getString(R.string.language_germany)),
            Language("sfsd", resources.getString(R.string.language_france)),
            Language("sfsd", resources.getString(R.string.language_china))
        )
        adapter.setData(listLanguage)
        with(binding) {
            recyclerviewLanguage.adapter = adapter
//            ivSelect.setOnClickListener {
//                findNavController().navigate(R.id.nav_fragmentLanguage_to_fragmentMenu)
//            }
        }

    }
}