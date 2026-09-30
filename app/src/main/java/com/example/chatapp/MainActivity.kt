package com.example.chatapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.adapter.ContactAdapter
import com.example.chatapp.data.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvContacts = findViewById<RecyclerView>(R.id.rvContacts)
        rvContacts.layoutManager = LinearLayoutManager(this)
        rvContacts.adapter = ContactAdapter(DataSource.contacts) { contact ->
            val intent = Intent(this, ChatActivity::class.java).apply {
                putExtra("CONTACT_ID", contact.id)
                putExtra("CONTACT_NAME", contact.name)
                putExtra("CONTACT_AVATAR", contact.avatarResId)
            }
            startActivity(intent)
        }
    }
}