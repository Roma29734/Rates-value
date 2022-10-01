package com.example.rate.screens.start

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rate.R
import com.example.rate.model.cash.CashItem
import kotlinx.android.synthetic.main.my_row.view.*

class CashAdapter: RecyclerView.Adapter<CashAdapter.CashViewHolder>() {

    private var listCash = emptyList<CashItem>()

    class CashViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CashViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_row, parent, false)
        return CashViewHolder(view)
    }

    override fun onBindViewHolder(holder: CashViewHolder, position: Int) {
        val list = listCash[position]
        holder.itemView.nameCurrency.text = list.ccy
        holder.itemView.buyCurrency.text = list.buy
        holder.itemView.saleCurrency.text = list.sale
    }

    override fun getItemCount(): Int {
        return listCash.size
    }

    fun setList(list: List<CashItem>) {
        listCash = list
        notifyDataSetChanged()
    }
}