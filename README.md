# 💬 Android Chat App - Micro Project

A modern, feature-rich Android Chat Application built using **Kotlin**, **Material Design 3**, **RecyclerView**, **Retrofit**, and **Firebase**.

---

## 🌟 Key Features

- 📇 **Contact List View**: Displays contacts with custom circular avatar logos, last message previews, timestamps, and unread badges.
- 💬 **Interactive Chat Screen**:
  - Distinct chat bubbles for sent vs. received messages.
  - Blue delivery checkmarks (`✓✓`) for sent messages.
  - Animated paper-airplane send button.
  - Instant simulated conversational replies.
- 🌐 **Retrofit Network Integration**: Asynchronous REST API network calls with Gson converter and offline fallback logic.
- 🔥 **Firebase Support**: Configured with `google-services.json` and Firebase Analytics.
- 🎨 **Custom UI Design**: Clean Material 3 styling with custom vector drawables.

---

## 🛠️ Tech Stack & Architecture

- **Language**: Kotlin 1.9+
- **Architecture**: MVVM / Clean Android Architecture
- **UI Components**: XML Layouts, MaterialToolbar, RecyclerView, ConstraintLayout, Shapeable Drawables
- **Networking**: Retrofit 2.9.0, Gson Converter
- **Backend / Services**: Firebase (Google Services, Analytics)
- **Build System**: Gradle KTS (Kotlin DSL)

---

## 📁 Project Structure

```
app/src/main/
├── java/com/example/chatapp/
│   ├── adapter/       # ContactAdapter & MessageAdapter
│   ├── data/          # DataSource & Mock Conversations
│   ├── model/         # Contact & Message Data Models
│   ├── network/       # Retrofit Client & API Services
│   ├── ChatActivity   # Chat detail screen & messaging logic
│   └── MainActivity   # Contact list screen
└── res/
    ├── drawable/      # Custom shape bubbles, avatars, & vector icons
    ├── layout/        # XML screen layouts & list item templates
    └── values/        # Colors, themes, & strings
```

---

## 🚀 How to Run

1. Clone this repository:
   ```bash
   git clone https://github.com/Shravan-mali/Chat-app.git
   ```
2. Open the project in **Android Studio**.
3. Sync Gradle and run the app on an Android Emulator or physical device.

---

## 👤 Author

Developed as an Android Micro Project by **[Shravan Mali](https://github.com/Shravan-mali)**.
