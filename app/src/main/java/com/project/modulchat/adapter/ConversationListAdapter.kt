package com.project.modulchat.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.modulchat.MainActivity
import com.project.modulchat.ProfileActivity
import com.project.modulchat.R
import com.project.modulchat.data.Conversation

class ConversationListAdapter(private val context: Context, private val conversations: List<Conversation>) :
    RecyclerView.Adapter<ConversationListAdapter.ConversationViewHolder>() {

    class ConversationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val usernameTextView: TextView = itemView.findViewById(R.id.username)
        val lastMessageTextView: TextView = itemView.findViewById(R.id.lastMessage)
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
        holder.profileImage.setImageResource(R.drawable.ic_person) // Set image resource

        // OnClickListener untuk membuka profil
        holder.profileImage.setOnClickListener {
            val profileIntent = Intent(context, ProfileActivity::class.java)
            profileIntent.putExtra("username", conversation.username)
            context.startActivity(profileIntent)
        }

        // OnClickListener untuk membuka percakapan detail
        holder.itemView.setOnClickListener {
            val conversationIntent = Intent(context, MainActivity::class.java)
            conversationIntent.putExtra("username", conversation.username)
            conversationIntent.putExtra("lastMessage", conversation.lastMessage)
            context.startActivity(conversationIntent)
        }
    }

    override fun getItemCount(): Int {
        return conversations.size
    }
}
