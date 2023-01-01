package com.example.whatssappmainactivitymock.project.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.whatssappmainactivitymock.R

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


private const val defaultImage= R.drawable.profile_image

private val allUsers: MutableList<User> = mutableListOf()
private val allChats: MutableList<Chat> = mutableListOf()
private val filteredChatList: MutableList<Chat> = mutableListOf()


private val user1 = User(1234234,defaultImage,"John", "Cohen",)
private val user2 = User(1234235,defaultImage,"Michael", "Potter")
private val user3 = User(1234236,defaultImage,"Orel", "Lev")
private val user4 = User(1234237,defaultImage,"Steve", "Gates")
private val user5 = User(1234238,defaultImage,"Itzik", "Lasso")
private val user6 = User(1234239,defaultImage,"John", "Cohen")
private val user7 = User(1234233,defaultImage,"Leon", "Heart")
private val user8 = User(1234231,defaultImage,"Stav", "Taylor")
private val user9 = User(1234235,defaultImage,"Moral", "Cortez")
private val user10 = User(12342343,defaultImage,"Jeff", "Daniels")


private const val firstMessage= "Yeah i'm coming!"
private const val secondMessage= "Don't tell"
private const val thirdMessage= "yes"
private const val fourthMessage= "My favorite.."
private const val fifthMessage= "What time?"
private const val sixthMessage= "its a snake!"
private const val seventhMessage= "Yeah i'm coming!"
private const val eighthMessage= "Wrong number"
private const val ninthMessage= "Liked it "
private const val tenthMessage= "its actually good"



private val topMessageInChat1 = Chat(user1, listOf(firstMessage))
private val topMessageInChat2 = Chat(user2, listOf(secondMessage))
private val topMessageInChat3 = Chat(user3, listOf(thirdMessage))
private val topMessageInChat4 = Chat(user4, listOf(fourthMessage))
private val topMessageInChat5 = Chat(user5, listOf(fifthMessage))
private val topMessageInChat6 = Chat(user6, listOf(sixthMessage))
private val topMessageInChat7 = Chat(user7, listOf(seventhMessage))
private val topMessageInChat8 = Chat(user8, listOf(eighthMessage))
private val topMessageInChat9 = Chat(user9,listOf(ninthMessage))
private val topMessageInChat10 = Chat(user10, listOf(tenthMessage))




fun getAllChats(): MutableList<Chat> {
    allChats.add(topMessageInChat1)
    allChats.add(topMessageInChat2)
    allChats.add(topMessageInChat3)
    allChats.add(topMessageInChat4)
    allChats.add(topMessageInChat5)
    allChats.add(topMessageInChat6)
    allChats.add(topMessageInChat7)
    allChats.add(topMessageInChat8)
    allChats.add(topMessageInChat9)
    allChats.add(topMessageInChat10)
    return allChats
}


fun getFilteredChats(): MutableList<Chat> {
    filteredChatList.add(topMessageInChat3)
    filteredChatList.add(topMessageInChat5)
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
