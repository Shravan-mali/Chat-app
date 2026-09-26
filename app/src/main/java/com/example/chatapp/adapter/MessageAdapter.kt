package com.example.chatapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.R
import com.example.chatapp.model.Message

class MessageAdapter(private val messages: List<Message>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_SENT = 1
        private const val VIEW_TYPE_RECEIVED = 2
    }

    class SentMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvMessageText: TextView = view.findViewById(R.id.tvMessageText)
        val tvMessageTime: TextView = view.findViewById(R.id.tvMessageTime)
        val tvCheckmarks: TextView = view.findViewById(R.id.tvCheckmarks)
    }

    class ReceivedMessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvMessageText: TextView = view.findViewById(R.id.tvMessageText)
        val tvMessageTime: TextView = view.findViewById(R.id.tvMessageTime)
    }

    override fun getItemViewType(position: Int): Int {
        return if (messages[position].isSentByMe) VIEW_TYPE_SENT else VIEW_TYPE_RECEIVED
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_SENT) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_message_sent, parent, false)
            SentMessageViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_message_received, parent, false)
            ReceivedMessageViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = messages[position]
        if (holder is SentMessageViewHolder) {
            holder.tvMessageText.text = message.text
            holder.tvMessageTime.text = message.timestamp
            holder.tvCheckmarks.text = "✓✓"
        } else if (holder is ReceivedMessageViewHolder) {
            holder.tvMessageText.text = message.text
            holder.tvMessageTime.text = message.timestamp
        }
    }

    override fun getItemCount(): Int = messages.size
}
