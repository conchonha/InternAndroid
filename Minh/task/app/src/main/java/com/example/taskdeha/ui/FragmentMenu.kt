package com.example.taskdeha.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.taskdeha.R
import com.example.taskdeha.databinding.FragmentMenuBinding
import com.example.taskdeha.ui.adapter.ViewPager2

class FragmentMenu : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(layoutInflater, container, false)
//        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
//        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ViewPager2(requireActivity())
        with(binding) {
            viewpager.adapter = adapter
            viewpager.offscreenPageLimit = 4
            binding.viewpager.isUserInputEnabled = false
            bottomNav.setOnNavigationItemSelectedListener { item ->
                viewpager.setCurrentItem(adapter.convertPositionTabFromMenuId(item.itemId),false)
                true
            }
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.menu_tool_bar, menu)
//        super.onCreateOptionsMenu(menu, inflater)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.menu_setting -> {
//                // Xử lý khi nhấn vào Item 1
//                return true
//            }
//            R.id.menu_search -> {
//                // Xử lý khi nhấn vào Item 2
//                return true
//            }
//            // Thêm xử lý cho các Item khác nếu cần
//            else -> return super.onOptionsItemSelected(item)
//        }
//    }
}