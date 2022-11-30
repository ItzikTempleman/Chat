package com.example.whatssappmainactivitymock.project.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chats_table")
data class Chat(
    @PrimaryKey
    val person:User, val messageList:List<ChatContent>)


