package com.example.whatssappmainactivitymock.project.models

import com.example.whatssappmainactivitymock.R


private const val defaultImage= R.drawable.profile_image

private val allUsers: MutableList<User> = mutableListOf()
private val allChats: MutableList<Chat> = mutableListOf()
private val filteredChatList: MutableList<Chat> = mutableListOf()


private val user1 = User("John", "Cohen")
private val user2 = User("Michael", "Potter")
private val user3 = User("Orel", "Lev")
private val user4 = User("Steve", "Gates")
private val user5 = User("Itzik", "Lasso")
private val user6 = User("John", "Cohen")
private val user7 = User("Leon", "Heart")
private val user8 = User("Stav", "Taylor")
private val user9 = User("Moral", "Cortez")
private val user10 = User("Jeff", "Daniels")


private val chat1 = Chat(1234234,user1, "Yeah i'm coming!", defaultImage)
private val chat2 = Chat(1234235,user2, "Don't tell",defaultImage)
private val chat3 = Chat(1234236,user3, "yes i am coming", defaultImage)
private val chat4 = Chat(1234237,user4, "My favorite..", defaultImage)
private val chat5 = Chat(1234238,user5, "Yesterday he was ok", defaultImage)
private val chat6 = Chat(1234239,user6, "What time?", defaultImage)
private val chat7 = Chat(1234233,user7, "its a snake!", defaultImage)
private val chat8 = Chat(1234231,user8, "Wrong number", defaultImage)
private val chat9 = Chat(12342343,user9, "Liked it ", defaultImage)
private val chat10 = Chat(123422,user10, "its actually good", defaultImage)




fun getAllChats(): MutableList<Chat> {
    allChats.add(chat1)
    allChats.add(chat2)
    allChats.add(chat3)
    allChats.add(chat4)
    allChats.add(chat5)
    allChats.add(chat6)
    allChats.add(chat7)
    allChats.add(chat8)
    allChats.add(chat9)
    allChats.add(chat10)
    return allChats
}


fun getFilteredChats(): MutableList<Chat> {
    filteredChatList.add(chat5)
    filteredChatList.add(chat3)
    return filteredChatList
}

fun getUsersForNewChatList(): MutableList<User> {
    allUsers.add(user1)
    allUsers.add(user2)
    allUsers.add(user3)
    allUsers.add(user4)
    allUsers.add(user5)
    return allUsers
}
