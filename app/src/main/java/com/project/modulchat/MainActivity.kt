package com.project.modulchat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.modulchat.adapter.CustomAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // Inisialisasi Layout Manager (menggunakan LinearLayoutManager, bisa diganti jika diperlukan)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Contoh data atau daftar data Anda yang akan ditampilkan dalam RecyclerView
        val data = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5")

        // Adapter untuk RecyclerView dengan menambahkan listener
        val adapter = CustomAdapter(data)

        // Atur adapter ke RecyclerView
        recyclerView.adapter = adapter
    }
}

