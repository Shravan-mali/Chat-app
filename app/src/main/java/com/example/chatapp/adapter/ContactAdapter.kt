package com.example.chatapp.adapter

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.R
import com.example.chatapp.model.Contact

class ContactAdapter(
    private val contacts: List<Contact>,
    private val onContactClick: (Contact) -> Unit
) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private val avatarColors = listOf(
        Color.parseColor("#2196F3"), // Blue - Mantavy
        Color.parseColor("#9C27B0"), // Purple - mohmad
        Color.parseColor("#FF9800"), // Orange - bhai
        Color.parseColor("#009688")  // Teal - smit
    )

    class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivAvatar: ImageView = view.findViewById(R.id.ivAvatar)
        val tvContactName: TextView = view.findViewById(R.id.tvContactName)
        val tvTime: TextView = view.findViewById(R.id.tvTime)
        val tvLastMessage: TextView = view.findViewById(R.id.tvLastMessage)
        val tvUnreadBadge: TextView = view.findViewById(R.id.tvUnreadBadge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contact, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.ivAvatar.setImageResource(contact.avatarResId)
        
        // Set distinct background color for each contact avatar
        val bgDrawable = GradientDrawable().apply {
            shape = GradientDrawable.OVAL
            setColor(avatarColors[position % avatarColors.size])
        }
        holder.ivAvatar.background = bgDrawable
        holder.ivAvatar.setPadding(12, 12, 12, 12)

        holder.tvContactName.text = contact.name
        holder.tvTime.text = contact.lastMessageTime
        holder.tvLastMessage.text = contact.lastMessage

        if (contact.unreadCount > 0) {
            holder.tvUnreadBadge.visibility = View.VISIBLE
            holder.tvUnreadBadge.text = contact.unreadCount.toString()
        } else {
            holder.tvUnreadBadge.visibility = View.GONE
        }

        holder.itemView.setOnClickListener {
            onContactClick(contact)
        }
    }

    override fun getItemCount(): Int = contacts.size
}
