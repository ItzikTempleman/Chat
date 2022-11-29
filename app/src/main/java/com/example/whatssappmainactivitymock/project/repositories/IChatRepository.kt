package com.example.whatssappmainactivitymock.project.repositories

import com.example.whatssappmainactivitymock.project.models.Chat

interface IChatRepository {

    suspend fun saveChat(chat: Chat)

    suspend fun getChat(): Chat

    suspend fun getAllChats(): MutableList<Chat>

    suspend fun deleteChats()

    suspend fun deleteChat(chat: Chat)
}