package com.example.rates.screen.privat

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.rates.R
import com.example.rates.screen.privat.viewModel.PrivatViewModel
import kotlinx.android.synthetic.main.fragment_privat.view.*

class PrivatFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: PrivatAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val viewModel = ViewModelProvider(this)[PrivatViewModel::class.java]
        val view = inflater.inflate(R.layout.fragment_privat, container, false)

        recyclerView = view.privatRecyclerView
        adapter = PrivatAdapter()
        recyclerView.adapter = adapter

        viewModel.getPrivateCourse()
        viewModel.myPrivatList.observe(viewLifecycleOwner) { list ->

            if(list.isSuccessful) {
                list.body()?.let { adapter.setList(it) }
                Log.d("Responce", "Передаю список в адаптер")
            } else {
                view.textWarningPrivat.text = list.code().toString()
                Log.d("Responce", list.errorBody().toString())
            }
        }
        return view
    }
}
