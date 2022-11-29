package com.example.whatssappmainactivitymock.project.data_source

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.whatssappmainactivitymock.project.models.Chat

@Dao
interface ChatDao {

    @Insert
    suspend fun insertAChat(chat: Chat)

    @Query("SELECT * FROM chats_table")
    suspend fun getAllChatsList(): MutableList<Chat>


    @Query("SELECT * FROM chats_table")
    suspend fun getSingleChat(): Chat

    @Delete
    suspend fun deleteAllChats()


    @Delete
    suspend fun deleteSingleChat(chat: Chat)
    
}