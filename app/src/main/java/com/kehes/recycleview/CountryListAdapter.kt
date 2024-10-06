package com.kehes.recycleview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kehes.recycleview.databinding.ItemCountryBinding

class CountryListAdapter(private val items: List<String>):
    RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(
            ItemCountryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    class CountryViewHolder(private val binding: ItemCountryBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: String) {
            //Log.e("item", ">>> item: $item")
            binding.root.text = item
        }
    }
}