package com.example.rates.screen.root

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.rates.R
import com.example.rates.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_root.view.*


class RootFragment : Fragment() {

    private var contex: Context?= null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        contex = context
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_root, container, false)

        view.viewPager.adapter = ViewPagerAdapter(contex as FragmentActivity)

        TabLayoutMediator(view.tableLayout, view.viewPager) {
                tab, pos ->
            when(pos) {
                0 -> {
                    tab.text = "Cbr"
                }
                1 -> {
                    tab.text = "Privat bank"
                }
            }
        }.attach()


        return view
    }

}