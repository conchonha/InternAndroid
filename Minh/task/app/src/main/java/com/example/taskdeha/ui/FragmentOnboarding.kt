package com.example.taskdeha.ui

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskdeha.R
import com.example.taskdeha.data.model.Introduce
import com.example.taskdeha.data.model.Language
import com.example.taskdeha.databinding.FragmentOnboardingBinding
import com.example.taskdeha.ui.adapter.IntroduceAdapter

class FragmentOnboarding : Fragment() {
    private lateinit var binding: FragmentOnboardingBinding
    private lateinit var adapter: IntroduceAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    companion object {
        fun getListIntroduce(resources: Resources): List<Introduce> {
            return listOf<Introduce>(
                Introduce(
                    R.drawable.ic_ringtones,
                    resources.getString(R.string.ringtones),
                    resources.getString(R.string.introduce)
                ),
                Introduce(
                    R.drawable.ic_bg_image,
                    resources.getString(R.string.bg_image),
                    resources.getString(R.string.introduce)
                ),
                Introduce(
                    R.drawable.ic_bg_call,
                    resources.getString(R.string.bg_call),
                    resources.getString(R.string.introduce)
                ),
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            adapter = IntroduceAdapter()
            adapter.updateData(getListIntroduce(resources))
            viewpagerIntroduce.adapter = adapter
            circleindicator.setViewPager(viewpagerIntroduce)
            btContinue.setOnClickListener {
                if (viewpagerIntroduce.currentItem == getListIntroduce(resources).size - 1) {
                    findNavController().navigate(R.id.fragmentMenu)
                } else {
                    viewpagerIntroduce.currentItem = viewpagerIntroduce.currentItem + 1
                }
            }
            tvSkip.setOnClickListener {
                findNavController().navigate(R.id.action_fragmentOnboarding_to_fragmentMenu)
            }
        }
    }
}