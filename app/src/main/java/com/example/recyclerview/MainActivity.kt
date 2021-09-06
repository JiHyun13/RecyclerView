package com.example.recyclerview

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val list : ArrayList<Data> = ArrayList()

        binding.rvMain.adapter = MainAdapter(list){data, position ->
            Toast.makeText(this, "아이템 삭제", Toast.LENGTH_SHORT).show()
            list.remove(data)
            binding.rvMain.adapter?.notifyItemRemoved(position)
        }

        binding.btnAdd.setOnClickListener{
            val randomInt = Random.nextInt(100).toString()
            Log.d(TAG, "onCreate : random : $randomInt")
            binding.rvMain.adapter?.notifyItemInserted(list.size.minus(1))
        }
    }
}