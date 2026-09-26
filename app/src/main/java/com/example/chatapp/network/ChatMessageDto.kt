package com.example.chatapp.network

data class ChatMessageDto(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
