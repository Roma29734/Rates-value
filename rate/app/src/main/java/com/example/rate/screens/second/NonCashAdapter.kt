package com.example.rate.screens.second

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rate.R
import com.example.rate.model.cash.CashItem
import com.example.rate.model.noncash.NonCashItem
import com.example.rate.screens.start.CashAdapter
import kotlinx.android.synthetic.main.my_row.view.*

class NonCashAdapter: RecyclerView.Adapter<NonCashAdapter.NonCashViewHolder>() {
    private var listNonCash = emptyList<NonCashItem>()

    class NonCashViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NonCashViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_row, parent, false)
        return NonCashViewHolder(view)
    }

    override fun onBindViewHolder(holder: NonCashViewHolder, position: Int) {
        val list = listNonCash[position]
        holder.itemView.nameCurrency.text = list.ccy
        holder.itemView.buyCurrency.text = list.buy
        holder.itemView.saleCurrency.text = list.sale
    }

    override fun getItemCount(): Int {
        return listNonCash.size
    }

    fun setList(list: List<NonCashItem>) {
        listNonCash = list
        notifyDataSetChanged()
    }
}