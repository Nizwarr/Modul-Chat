package com.project.modulchat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.modulchat.adapter.ConversationListAdapter
import com.project.modulchat.data.Conversation

class ConversationListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversation_list)

        // Inisialisasi RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.rv_conversation)

        // Inisialisasi Layout Manager
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        // Buat contoh data atau daftar data percakapan
        val conversations = listOf(
            Conversation("User1", "Hello!", "10:00 AM"),
            Conversation("User2", "Hi there!", "11:30 AM"),
            // Tambahkan data percakapan lainnya sesuai kebutuhan
        )

        // Buat adapter untuk RecyclerView
        val adapter = ConversationListAdapter(this, conversations)

        // Atur adapter ke RecyclerView
        recyclerView.adapter = adapter
    }
}
