package com.kehes.recycleview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kehes.recycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var position = 0
        val countryList = CountryListMaker.getCountryList(this)
        val list: MutableList<CountryListDto> = mutableListOf()
        countryList.forEachIndexed{ index, item ->
            if (index % 5 == 0) list.add(CountryListDto(CountryListType.REGION_VIEW, "Region $index"))
            else list.add(CountryListDto(CountryListType.COUNTRY_VIEW, item))
        }
        val adapter = CountryListAdapter(list)

        binding.listView.adapter = adapter
        binding.listView.layoutManager = LinearLayoutManager(this)

        binding.addButton.setOnClickListener {
            countryList[position] = position.toString()
            adapter.notifyItemChanged(position)
            position++

            /*
            list.add(countryList[list.size])
            adapter.notifyItemRangeChanged(list.size, list.size)
*/
        }
    }
}