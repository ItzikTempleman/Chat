package com.example.whatssappmainactivitymock.project.modules

import android.content.Context
import androidx.room.Room
import com.example.whatssappmainactivitymock.project.data.ChatDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app, ChatDatabase::class.java, "chat_db").build()


    @Singleton
    @Provides
    fun provideDao(db: ChatDatabase) = db.userDao()
}