package com.example.chatapp.data

import com.example.chatapp.R
import com.example.chatapp.model.Contact
import com.example.chatapp.model.Message

object DataSource {
    val contacts = listOf(
        Contact(
            id = "mantavy",
            name = "Mantavy",
            lastMessage = "Hey, are you free for a call?",
            lastMessageTime = "11:30 AM",
            unreadCount = 1,
            avatarResId = R.drawable.ic_contact_person
        ),
        Contact(
            id = "mohmad",
            name = "mohmad",
            lastMessage = "Check out this new micro project update.",
            lastMessageTime = "10:15 AM",
            unreadCount = 0,
            avatarResId = R.drawable.ic_contact_person
        ),
        Contact(
            id = "bhai",
            name = "bhai",
            lastMessage = "Let's catch up later today!",
            lastMessageTime = "Yesterday",
            unreadCount = 0,
            avatarResId = R.drawable.ic_contact_person
        ),
        Contact(
            id = "smit",
            name = "smit",
            lastMessage = "Task completed successfully.",
            lastMessageTime = "Monday",
            unreadCount = 0,
            avatarResId = R.drawable.ic_contact_person
        )
    )

    private val messageStore = mutableMapOf<String, MutableList<Message>>(
        "mantavy" to mutableListOf(
            Message("1", "mantavy", "Hey, are you free for a call?", "11:30 AM", false)
        ),
        "mohmad" to mutableListOf(
            Message("1", "mohmad", "Check out this new micro project update.", "10:15 AM", false)
        ),
        "bhai" to mutableListOf(
            Message("1", "bhai", "Let's catch up later today!", "Yesterday", false)
        ),
        "smit" to mutableListOf(
            Message("1", "smit", "Task completed successfully.", "Monday", false)
        )
    )

    fun getMessagesForContact(contactId: String): MutableList<Message> {
        return messageStore.getOrPut(contactId) { mutableListOf() }
    }

    fun addMessage(contactId: String, message: Message) {
        val list = messageStore.getOrPut(contactId) { mutableListOf() }
        list.add(message)
    }

    fun getBotReply(userMessage: String): String {
        val lower = userMessage.lowercase()
        return when {
            lower.contains("hello") || lower.contains("hi") -> "Hey there! How's it going?"
            lower.contains("project") || lower.contains("micro") -> "This chat app micro project is looking great!"
            lower.contains("help") -> "I'm here and ready to help you out!"
            else -> "Got it! Let's keep working on our micro project."
        }
    }
}
