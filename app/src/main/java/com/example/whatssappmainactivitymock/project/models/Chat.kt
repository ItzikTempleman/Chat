package com.example.whatssappmainactivitymock.project.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chats_table")
data class Chat(
    @PrimaryKey
    var id:Long,
    val name:User, val summary:String, val image:Int)


