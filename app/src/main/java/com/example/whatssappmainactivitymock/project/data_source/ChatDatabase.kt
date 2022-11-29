package com.example.whatssappmainactivitymock.project.data_source

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.whatssappmainactivitymock.project.ApplicationContext
import com.example.whatssappmainactivitymock.project.models.Chat

@Database(entities = [Chat::class], version = 1)
abstract class ChatDatabase : RoomDatabase() {

    abstract fun userDao(): ChatDao

}