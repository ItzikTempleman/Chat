package com.example.whatssappmainactivitymock.project.viewmodel
import androidx.lifecycle.ViewModel
import com.example.whatssappmainactivitymock.project.models.Chat
import com.example.whatssappmainactivitymock.project.repositories.ChatRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(private val repository: ChatRepository) : ViewModel() {
    suspend fun insertChat(chat: Chat) = repository.saveChat(chat)

    
}