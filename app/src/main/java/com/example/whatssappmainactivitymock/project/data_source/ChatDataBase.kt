package com.example.whatssappmainactivitymock.project.data_source

import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.whatssappmainactivitymock.project.ApplicationContext.Companion.getInstance
import com.example.whatssappmainactivitymock.project.models.Chat

@Database(entities = [Chat::class], version = 1)
abstract class ChatDataBase : RoomDatabase() {
    val chatDatabase = Room.databaseBuilder(
        getInstance,
        ChatDataBase::class.java, "chat_db"
    ).build()
}