package com.example.whatssappmainactivitymock.project.repositories

import com.example.whatssappmainactivitymock.project.data_source.ChatDao
import com.example.whatssappmainactivitymock.project.models.Chat
import javax.inject.Inject

class ChatRepository @Inject constructor(private val chatDao: ChatDao){

    suspend fun saveChat(chat: Chat)= chatDao.insertAChat(chat)


    suspend fun getChat() = chatDao.getSingleChat()

    suspend fun getAllChats() = chatDao.getAllChatsList()

    suspend fun deleteChats()=chatDao.deleteAllChats()

    suspend fun deleteChat(chat: Chat)=chatDao.deleteSingleChat(chat)

}