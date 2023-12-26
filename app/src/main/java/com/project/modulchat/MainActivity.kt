package com.project.modulchat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.modulchat.adapter.ChatAdapter

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
        val data = listOf("Halo, ini adalah text yang cukup panjang untuk ditampilkan", "Apakah sudah lumayan cukup?", "Atau kurang?", "Oke", "1")

        // Adapter untuk RecyclerView dengan menambahkan listener
        val adapter = ChatAdapter(data)

        // Atur adapter ke RecyclerView
        recyclerView.adapter = adapter
    }
}

