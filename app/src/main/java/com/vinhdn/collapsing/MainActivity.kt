package com.vinhdn.collapsing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.vinhdn.collapsing.databinding.ActivityMainBinding
import com.vinhdn.collapsing.databinding.ItemProductBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btnScrollToTop.setOnClickListener {
                motionView.transitionToStart()
                recyclerView.scrollToPosition(0)
            }
            recyclerView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = ProductAdapter()
            }
        }
    }

    inner class ProductAdapter : Adapter<Holder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            return Holder(
                ItemProductBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }

        override fun getItemCount() = 50

        override fun onBindViewHolder(holder: Holder, position: Int) {

        }
    }

    inner class Holder(binding: ItemProductBinding) : ViewHolder(binding.root)
}