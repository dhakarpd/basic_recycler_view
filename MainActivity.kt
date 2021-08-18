package com.example.newsfresh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), newsItemClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager=LinearLayoutManager(this)
        val items = fetchData()
        val adapter= NewsListAdapter(items,this)
        recyclerView.adapter=adapter
    }

    /*Function to get some normal string data for our views
      having return type as arrayList of strings*/
    private fun fetchData():ArrayList<String>{
        val list = ArrayList<String>()
        for (i in 0 until 100)
        {
            list.add("Item $i")
        }
        return list
    }

    override fun onItemClicked(item: String) {
        Toast.makeText(this,"Item $item is clicked",Toast.LENGTH_SHORT).show()
    }
}