package com.example.taskdeha.ui.language


import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
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


class FragmentLanguage : BaseFragment<FragmentLanguageBinding, LanguageViewModel>() {
    override val layoutId: Int = R.layout.fragment_language
    private lateinit var adapter: LanguageAdapter
    private var language = Language()
    var dialog = CustomDialog()

    override fun onInternetChange(isNetWork: Boolean) {
        if (dialog.isVisible) {
            dialog.dismiss()
            dialog = CustomDialog()
        }
        if (isNetWork) {
            dialog.dialogData = DialogData(isShow = true, message = "Đã kết nối mạng")
//            Toast.makeText(context, "Đã có kết nối mạnggg", Toast.LENGTH_SHORT).show()
        } else {

            dialog.dialogData = DialogData(isShow = false, message = "Đã ngắt kết nối mạng")
//            Toast.makeText(context, "Mất kết nối mạnggg", Toast.LENGTH_SHORT).show()
        }
        dialog.show(parentFragmentManager, "")
    }

    override val viewModel: LanguageViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = LanguageAdapter()

        adapter.setData(listLanguage)
        with(binding) {
            recyclerviewLanguage.adapter = adapter
            ivSelect.setOnClickListener {
                if (language.nameLanguage != null) {
                   showToast()
                    findNavController().navigate(R.id.action_fragmentLanguage_to_fragmentMenu)
                } else {
                    Toast.makeText(context, "Please select a language!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        adapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(position: Int) {
                language = adapter.getLanguage(position)
                TextView(requireContext()).setText(R.string.language_china)
            }
        })
    }

    companion object{
        val listLanguage = getListLanguage()

        fun getListLanguage() = listOf<Language>(
                Language(
                    R.drawable.ic_flag_united_kingdom,
                    R.string.language_english
                ),
                Language(
                    R.drawable.ic_flag_united_kingdom,
                    resources.getString(R.string.language_spain)
                ),
                Language(
                    R.drawable.ic_flag_portugal,
                    resources.getString(R.string.language_portugal)
                ),
                Language(
                    R.drawable.ic_flag_india,
                    resources.getString(R.string.language_hindi)
                ),
                Language(
                    R.drawable.ic_flag_germany,
                    resources.getString(R.string.language_germany)
                ),
                Language(
                    R.drawable.ic_flag_france,
                    resources.getString(R.string.language_france)
                ),
                Language(
                    R.drawable.ic_flag_china,
                    resources.getString(R.string.language_china)
                )
            )
        }
    }
}