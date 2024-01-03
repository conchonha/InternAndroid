package com.example.learnnavigation.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learnnavigation.R
import com.example.learnnavigation.data.model.languageCountry
import com.example.learnnavigation.databinding.FragmentChangeLanguageBinding
import com.example.learnnavigation.ui.adapter.LanguageCountryAdapter
import com.example.learnnavigation.ui.viewmodel.BackgroundImageViewModel
import com.example.learnnavigation.ui.viewmodel.EventToolbar
import com.example.learnnavigation.ui.viewmodel.ShareViewModel
import com.example.learnnavigation.utils.LocaleHelper


class FragmentChangeLanguage :
    BaseFragmentDataBinding<FragmentChangeLanguageBinding, BackgroundImageViewModel>() {
    override val layoutId: Int = R.layout.fragment_change_language
    override val vm: BackgroundImageViewModel by viewModels()
    private val shareViewModel: ShareViewModel by activityViewModels()

    val languages = listOf(
        languageCountry(R.drawable.ic_japanflag, "Japanese"),
        languageCountry(R.drawable.ic_chinaflag, "China"),
        languageCountry(R.drawable.ic_franceflag, "France"),
        languageCountry(R.drawable.ic_englishflag, "English"),
        languageCountry(R.drawable.ic_spanshflag, "Spanish"),
        languageCountry(R.drawable.ic_indianflag, "Indian"),
        languageCountry(R.drawable.ic_koreaflag, "Korean")
    )
    private var isLanguageSelected = false
    private var isLanguageName:String?=null

    private val adapter by lazy {
        LanguageCountryAdapter(
            languages
        ) { languageName ->
            isLanguageName = languageName
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shareViewModel.chanEvent(EventToolbar.OpenSearch)

        with(binding) {
            recycleViewChartFragment.layoutManager = LinearLayoutManager(requireContext())
            recycleViewChartFragment.adapter = adapter

            ivChoosingLanguage.setOnClickListener {
                handleLanguageSelected()
            }
        }
    }

    override fun onInternetChange(isNetWork: Boolean) {}

    private fun handleLanguageSelected() {
        if(isLanguageName != null){
            val sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("selectedLanguage", isLanguageName)
            editor.apply()

            findNavController().navigate(R.id.action_changeLanguageFragment_to_fragmentHost2)
        }else{
            Toast.makeText(requireContext(), "Please, Choosing Language", Toast.LENGTH_LONG).show()
        }

    }
}