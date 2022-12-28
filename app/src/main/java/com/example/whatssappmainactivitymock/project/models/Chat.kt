package com.example.whatssappmainactivitymock.project.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chats_table")
data class Chat(
    @PrimaryKey
    val user:User, val messageList:List<String>)



data class User(
    var id:Long,
    val image:Int,
    var firstName: String,
    var familyName: String,
)
