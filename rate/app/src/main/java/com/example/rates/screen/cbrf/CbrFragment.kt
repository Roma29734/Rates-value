package com.example.rates.screen.cbrf

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.rates.R
import com.example.rates.data.repository.Repository
import com.example.rates.screen.cbrf.viewModel.MainViewModel
import com.example.rates.screen.cbrf.viewModel.cbrViewModelFactory
import kotlinx.android.synthetic.main.fragment_cbr.view.*

class CbrFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CbrAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_cbr, container, false)

        recyclerView = view.recyclerView
        adapter = CbrAdapter()
        recyclerView.adapter = adapter


        val repository = Repository()

        var courseList = emptyList<Double>()

        val viewModelFactory = cbrViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getCourse()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->
            if(response.isSuccessful) {
                val nameList = listOf("RUB", "EUR", "UAN")
                val secondList = listOf(response.body()?.rates?.RUB, response.body()?.rates?.EUR, response.body()?.rates?.UAH)
                adapter.setList(secondList as List<Double>)
                adapter.setName(nameList)
            }else {
                view.textViewWarningCbr.text = response.code().toString()
                view.textViewRecommendCbr.setText(R.string.recommendToApp)
                Log.d("Responce", response.errorBody().toString())
            }
        })
        return view
    }
}

