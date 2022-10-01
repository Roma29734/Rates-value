package com.example.rate.screens.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.rate.R
import com.example.rate.screens.start.CashAdapter
import com.example.rate.screens.start.CashViewModel
import kotlinx.android.synthetic.main.fragment_cash.view.*
import kotlinx.android.synthetic.main.fragment_non_cash.view.*


class NonCashFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: NonCashAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val viewModel = ViewModelProvider(this)[NonCashViewModel::class.java]
        val view = inflater.inflate(R.layout.fragment_non_cash, container, false)

        recyclerView = view.nonCashRecyclerView
        adapter = NonCashAdapter()
        recyclerView.adapter = adapter

        viewModel.getNonCashMoney()
        viewModel.myNonCashList.observe(viewLifecycleOwner) { list ->
            list.body()?.let { adapter.setList(it) }
        }

        return  view
    }
}