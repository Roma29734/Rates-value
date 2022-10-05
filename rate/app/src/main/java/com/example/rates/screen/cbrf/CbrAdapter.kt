package com.example.rates.screen.cbrf

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rates.R
import kotlinx.android.synthetic.main.my_row.view.*

class CbrAdapter: RecyclerView.Adapter<CbrAdapter.CashViewHolder>() {

    private var listCash = emptyList<Double>()
    private var listName = emptyList<String>()

    class CashViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CashViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_row, parent, false)
        return CashViewHolder(view)
    }

    override fun onBindViewHolder(holder: CashViewHolder, position: Int) {
        val list = listCash[position]
        val listName = listName[position]
        holder.itemView.nameCurrency.text = "USD"
        holder.itemView.buyCurrency.text = list.toString()
        holder.itemView.nameFirstCurrency.text = listName
    }

    override fun getItemCount(): Int {
        return listCash.size
    }

    fun setList(list: List<Double>) {
        listCash = list
        notifyDataSetChanged()
    }

    fun setName(list: List<String>) {
        listName = list
        notifyDataSetChanged()
    }
}