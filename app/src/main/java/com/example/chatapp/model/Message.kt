package com.example.chatapp.model

data class Message(
    val id: String,
    val senderId: String,
    val text: String,
    val timestamp: String,
    val isSentByMe: Boolean
)
