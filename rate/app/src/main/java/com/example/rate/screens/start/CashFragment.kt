package com.example.rate.screens.start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.rate.R
import kotlinx.android.synthetic.main.fragment_cash.view.*


class CashFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CashAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val viewModel = ViewModelProvider(this)[CashViewModel::class.java]
        val view =  inflater.inflate(R.layout.fragment_cash, container, false)

//        обьявление присвоение adapter recycler
        recyclerView = view.cashRecyclerView
        adapter = CashAdapter()
        recyclerView.adapter = adapter

        viewModel.getCashMoney()
        viewModel.myCashList.observe(viewLifecycleOwner) { list ->
            list.body()?.let { adapter.setList(it) }
        }

        return view
    }
}