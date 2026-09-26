package com.example.chatapp.model

data class Contact(
    val id: String,
    val name: String,
    val lastMessage: String,
    val lastMessageTime: String,
    val unreadCount: Int,
    val avatarResId: Int
)
