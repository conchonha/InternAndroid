    package com.example.learnnavigation.ui.fragment

    import android.os.Bundle
    import android.view.View
    import androidx.fragment.app.activityViewModels
    import androidx.fragment.app.viewModels
    import androidx.navigation.fragment.findNavController
    import com.example.learnnavigation.R
    import com.example.learnnavigation.data.model.languageCountry
    import com.example.learnnavigation.databinding.FragmentChangeLanguageBinding
    import com.example.learnnavigation.ui.adapter.LanguageAdapter
    import com.example.learnnavigation.ui.viewmodel.ChangedLanguageViewModel
    import com.example.learnnavigation.ui.viewmodel.EventToolbar
    import com.example.learnnavigation.ui.viewmodel.ShareViewModel
    import com.example.learnnavigation.utils.Const.LANGUAGE
    import com.example.learnnavigation.utils.LocaleManager
    import com.example.learnnavigation.utils.SharePrefs

    class FragmentChangeLanguage :
        BaseFragmentDataBinding<FragmentChangeLanguageBinding, ChangedLanguageViewModel>() {
        override val layoutId: Int = R.layout.fragment_change_language
        override val vm: ChangedLanguageViewModel by viewModels()
        private val shareViewModel: ShareViewModel by activityViewModels()

        private val adapter by lazy {
            LanguageAdapter(vm)
        }

        private val languageList = LANGUAGE

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            shareViewModel.chanEvent(EventToolbar.OpenSearch)

            with(binding) {
                adapter.updateItems(languageList)
                recycleViewChartFragment.adapter = adapter
                ivChoosingLanguage.setOnClickListener {
                    vm.changeLanguage()
                }
            }
        }
    }