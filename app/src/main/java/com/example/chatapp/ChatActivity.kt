package com.example.chatapp

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.adapter.MessageAdapter
import com.example.chatapp.data.DataSource
import com.example.chatapp.model.Message
import com.example.chatapp.network.ChatMessageDto
import com.example.chatapp.network.RetrofitClient
import com.google.android.material.appbar.MaterialToolbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ChatActivity : AppCompatActivity() {

    private lateinit var contactId: String
    private lateinit var contactName: String
    private var avatarResId: Int = R.drawable.ic_contact_person
    private lateinit var messageAdapter: MessageAdapter
    private lateinit var messagesList: MutableList<Message>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chat)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainChat)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        contactId = intent.getStringExtra("CONTACT_ID") ?: "mantavy"
        contactName = intent.getStringExtra("CONTACT_NAME") ?: "Chat"
        avatarResId = intent.getIntExtra("CONTACT_AVATAR", R.drawable.ic_contact_person)

        val toolbar = findViewById<MaterialToolbar>(R.id.chatToolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }

        val ivToolbarAvatar = findViewById<ImageView>(R.id.ivToolbarAvatar)
        val tvToolbarTitle = findViewById<TextView>(R.id.tvToolbarTitle)

        tvToolbarTitle.text = contactName
        ivToolbarAvatar.setImageResource(avatarResId)

        // Set matching circular avatar background color
        val bgColor = when (contactId) {
            "mantavy" -> Color.parseColor("#2196F3")
            "mohmad" -> Color.parseColor("#9C27B0")
            "bhai" -> Color.parseColor("#FF9800")
            "smit" -> Color.parseColor("#009688")
            else -> Color.parseColor("#2196F3")
        }
        val bgDrawable = GradientDrawable().apply {
            shape = GradientDrawable.OVAL
            setColor(bgColor)
        }
        ivToolbarAvatar.background = bgDrawable
        ivToolbarAvatar.setPadding(8, 8, 8, 8)

        messagesList = DataSource.getMessagesForContact(contactId)

        val rvMessages = findViewById<RecyclerView>(R.id.rvMessages)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.stackFromEnd = true
        rvMessages.layoutManager = layoutManager

        messageAdapter = MessageAdapter(messagesList)
        rvMessages.adapter = messageAdapter

        val etMessage = findViewById<EditText>(R.id.etMessage)
        val btnSend = findViewById<View>(R.id.btnSend)

        btnSend.setOnClickListener {
            val text = etMessage.text.toString().trim()
            if (text.isNotEmpty()) {
                val timeString = SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date())
                val userMsg = Message(
                    id = System.currentTimeMillis().toString(),
                    senderId = "me",
                    text = text,
                    timestamp = timeString,
                    isSentByMe = true
                )
                messagesList.add(userMsg)
                messageAdapter.notifyItemInserted(messagesList.size - 1)
                rvMessages.scrollToPosition(messagesList.size - 1)
                etMessage.setText("")

                // Get smart conversational reply
                val replyText = DataSource.getBotReply(text)
                rvMessages.postDelayed({
                    appendReply(replyText, rvMessages)
                }, 600)
            }
        }
    }

    private fun appendReply(replyText: String, rvMessages: RecyclerView) {
        val replyMsg = Message(
            id = (System.currentTimeMillis() + 1).toString(),
            senderId = contactId,
            text = replyText,
            timestamp = SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date()),
            isSentByMe = false
        )
        messagesList.add(replyMsg)
        messageAdapter.notifyItemInserted(messagesList.size - 1)
        rvMessages.scrollToPosition(messagesList.size - 1)
    }
}
