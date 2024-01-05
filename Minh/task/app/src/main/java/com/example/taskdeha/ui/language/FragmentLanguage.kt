package com.example.taskdeha.ui.language

import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat.recreate
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.taskdeha.R
import com.example.taskdeha.base.BaseFragment
import com.example.taskdeha.data.model.Language
import com.example.taskdeha.data.model.dialog.DialogData
import com.example.taskdeha.databinding.FragmentLanguageBinding
import com.example.taskdeha.ui.adapter.LanguageAdapter
import com.example.taskdeha.ui.adapter.OnItemClickListener
import com.example.taskdeha.utils.CustomDialog
import com.example.taskdeha.utils.DialogUtils
import com.example.taskdeha.utils.LocaleManager
import com.example.taskdeha.utils.MySharedPreferences
import java.util.*

class FragmentLanguage : BaseFragment<FragmentLanguageBinding, LanguageViewModel>() {
    override val layoutId: Int = R.layout.fragment_language
    private lateinit var adapter: LanguageAdapter
    private var language = Language()
    var dialog = CustomDialog()

    companion object {
        fun getListLanguage(resources: Resources): List<Language> {
            return listOf<Language>(
                Language(
                    R.drawable.ic_flag_united_kingdom,
                    resources.getString(R.string.language_english),
                    R.string.const_eng
                ),
                Language(
                    R.drawable.ic_flag_spain,
                    resources.getString(R.string.language_spain),
                    R.string.const_spain
                ),
                Language(
                    R.drawable.ic_flag_portugal,
                    resources.getString(R.string.language_portugal),
                    R.string.const_portugal
                ),
                Language(
                    R.drawable.ic_flag_india,
                    resources.getString(R.string.language_hindi),
                    R.string.const_india
                ),
                Language(
                    R.drawable.ic_flag_germany,
                    resources.getString(R.string.language_germany),
                    R.string.const_germany
                ),
                Language(
                    R.drawable.ic_flag_france,
                    resources.getString(R.string.language_france),
                    R.string.const_france
                ),
                Language(
                    R.drawable.ic_flag_china,
                    resources.getString(R.string.language_china),
                    R.string.const_china
                )
            )
        }
    }

    override val viewModel: LanguageViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = LanguageAdapter()
        val listLanguage = getListLanguage(resources)
        adapter.setData(listLanguage)
        with(binding) {
            recyclerviewLanguage.adapter = adapter
            ivSelect.setOnClickListener {
                if (language.nameLanguage != null) {
                    Toast.makeText(
                        context,
                        language.nameLanguage,
                        Toast.LENGTH_SHORT
                    ).show()
                    language.locale?.let { languageLocale ->
                        context?.getString(languageLocale)?.let { locale ->
                            setLocale(locale)
//                            LocaleManager.updateResources(requireContext(), locale)
                            MySharedPreferences.putString("locale", locale)
                        }
                    }
                    setFirstLaunch(false)
                    findNavController().navigate(R.id.action_fragmentLanguage_to_fragmentOnboarding)
                } else {
                    Toast.makeText(context, "Please select a language!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
        adapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(position: Int) {
                language = adapter.getLanguage(position)
            }
        })
    }

    private fun setLocale(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val configuration = Configuration()
        configuration.setLocale(locale)

        // Áp dụng ngôn ngữ mới cho ứng dụng
        resources.updateConfiguration(configuration, resources.displayMetrics)

        // Re-create activity để cập nhật giao diện với ngôn ngữ mới
        activity?.recreate()
    }

    private fun setFirstLaunch(isFirstTime: Boolean) {
        MySharedPreferences.putBoolean("firstLaunch", isFirstTime)
    }
}


