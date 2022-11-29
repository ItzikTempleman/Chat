package com.example.whatssappmainactivitymock.project.repositories

import com.example.whatssappmainactivitymock.project.data_source.ChatDao
import com.example.whatssappmainactivitymock.project.models.Chat
import javax.inject.Inject

class ChatRepository @Inject constructor(private val chatDao: ChatDao): IRepository{

    override suspend fun saveChat(chat: Chat)=chatDao.insertAChat(chat)

    override suspend fun getChat() = chatDao.getSingleChat()

    override suspend fun getAllChats() =chatDao.getAllChatsList()

    override suspend fun deleteChats() =chatDao.deleteAllChats()

    override suspend fun deleteChat(chat: Chat)=chatDao.deleteSingleChat(chat)

}