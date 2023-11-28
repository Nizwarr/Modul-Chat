package com.project.modulchat.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.modulchat.MainActivity
import com.project.modulchat.R
import com.project.modulchat.data.Conversation

class ConversationListAdapter(private val conversations: List<Conversation>) :
    RecyclerView.Adapter<ConversationListAdapter.ConversationViewHolder>() {

    class ConversationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val usernameTextView: TextView = itemView.findViewById(R.id.username)
        val lastMessageTextView: TextView = itemView.findViewById(R.id.lastMessage)
        val timestampTextView: TextView = itemView.findViewById(R.id.timestamp)
        val container: View = itemView.findViewById(R.id.container)
        val profileImage: ImageView = itemView.findViewById(R.id.profileImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConversationViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_conversation, parent, false)
        return ConversationViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ConversationViewHolder, position: Int) {
        val conversation = conversations[position]
        holder.usernameTextView.text = conversation.username
        holder.lastMessageTextView.text = conversation.lastMessage
        holder.timestampTextView.text = conversation.timestamp
        holder.profileImage.setImageResource(R.drawable.ic_person) // Set image resource

        // Tambahkan OnClickListener pada container
        holder.container.setOnClickListener {
            // Handle klik pada elemen daftar percakapan di sini
            val intent = Intent(holder.container.context, MainActivity::class.java)
            intent.putExtra("username", conversation.username)
            intent.putExtra("lastMessage", conversation.lastMessage)
            holder.container.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return conversations.size
    }
}