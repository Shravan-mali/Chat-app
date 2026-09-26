# Feature-Rich Chat App Implementation Plan

We will build a complete, modern Android Chat App micro-project using Kotlin, XML layouts, RecyclerView, Material Design 3, and Coroutines.

## User Review Required

> [!NOTE]
> The app will feature a Contact/Chat List screen (MainActivity) and an individual Chat Detail screen (ChatActivity) with simulated AI bot replies and peer messaging, message timestamps, and chat bubbles.

## Proposed Changes

### Data Models & Source
- [NEW] [Contact.kt](file:///C:/Chat app/app/src/main/java/com/example/chatapp/model/Contact.kt): Data class representing a chat contact (name, avatar, last message, time, unread count).
- [NEW] [Message.kt](file:///C:/Chat app/app/src/main/java/com/example/chatapp/model/Message.kt): Data class representing a chat message (text, sender, timestamp, isSentByMe).
- [NEW] [DataSource.kt](file:///C:/Chat app/app/src/main/java/com/example/chatapp/data/DataSource.kt): Provides mock contacts and preset conversations (including an AI Smart Assistant that replies automatically).

### Adapters
- [NEW] [ContactAdapter.kt](file:///C:/Chat app/app/src/main/java/com/example/chatapp/adapter/ContactAdapter.kt): RecyclerView adapter for displaying the list of chats with avatars and unread badges.
- [NEW] [MessageAdapter.kt](file:///C:/Chat app/app/src/main/java/com/example/chatapp/adapter/MessageAdapter.kt): RecyclerView adapter supporting two view types (sent and received chat bubbles).

### UI Layouts
- [NEW] [activity_main.xml](file:///C:/Chat app/app/src/main/res/layout/activity_main.xml): Main screen layout with Toolbar, RecyclerView for chats, and FloatingActionButton for new chat.
- [NEW] [activity_chat.xml](file:///C:/Chat app/app/src/main/res/layout/activity_chat.xml): Chat detail screen layout with Toolbar, RecyclerView for messages, and bottom input bar (EditText + Send Button).
- [NEW] [item_contact.xml](file:///C:/Chat app/app/src/main/res/layout/item_contact.xml): Item layout for chat list.
- [NEW] [item_message_sent.xml](file:///C:/Chat app/app/src/main/res/layout/item_message_sent.xml): Sent chat bubble layout.
- [NEW] [item_message_received.xml](file:///C:/Chat app/app/src/main/res/layout/item_message_received.xml): Received chat bubble layout.

### Activities & Logic
- [MODIFY] [MainActivity.kt](file:///C:/Chat app/app/src/main/java/com/example/chatapp/MainActivity.kt): Displays contact list, handles clicks to open chat activity.
- [NEW] [ChatActivity.kt](file:///C:/Chat app/app/src/main/java/com/example/chatapp/ChatActivity.kt): Handles messaging, message list updates, auto-scroll to bottom, and simulated automated bot/peer responses.

### Resources
- [MODIFY] [strings.xml](file:///C:/Chat app/app/src/main/res/values/strings.xml) & [colors.xml](file:///C:/Chat app/app/src/main/res/values/colors.xml): App name, chat themes, and bubble colors.

## Verification Plan

### Automated Tests
- Build verification via Gradle (`app:assembleDebug`).

### Manual Verification
- Deploy and run the app on an Android emulator/device.
- Verify contact list displays correctly.
- Tap a contact to open chat.
- Send a message and verify it appears as a sent bubble.
- Receive simulated automated reply from AI Assistant or contact.
