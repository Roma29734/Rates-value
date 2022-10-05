package com.example.rates.screen.privat

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rates.R
import com.example.rates.model.privat.Privat
import com.example.rates.model.privat.PrivatItem
import com.example.rates.screen.cbrf.CbrAdapter
import kotlinx.android.synthetic.main.my_row.view.*

class PrivatAdapter: RecyclerView.Adapter<PrivatAdapter.PrivatViewHolder>() {

    private var listPrivat = emptyList<PrivatItem>()

    class PrivatViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrivatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.my_row, parent, false)
        return PrivatViewHolder(view)
    }

    override fun onBindViewHolder(holder: PrivatViewHolder, position: Int) {
        val list = listPrivat[position]

        holder.itemView.nameFirstCurrency.text = list.ccy
        holder.itemView.nameCurrency.text = list.base_ccy
        holder.itemView.buyCurrency.text = list.buy

        Log.d("Responce", "Установил значения в адаптере")
    }

    override fun getItemCount(): Int {
        return listPrivat.size
    }

    fun setList(list: List<PrivatItem>) {
        listPrivat = list
        Log.d("Responce", "Установил переданный список на листПриват")
        notifyDataSetChanged()
    }
}