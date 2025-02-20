package com.androidsrit.roomdb

import android.app.Application
import androidx.room.Room
import com.androidsrit.roomdb.data.Repository
import com.androidsrit.roomdb.data.database.ContactDatabase
import com.androidsrit.roomdb.data.database.MIGRATION_1_2
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application): ContactDatabase {
        return Room.databaseBuilder(
                application,
                ContactDatabase::class.java,
                "contact_database.sql"
            ).addMigrations(MIGRATION_1_2).build()
    }


    @Provides
    @Singleton
    fun provideRepo(database: ContactDatabase): Repository {
        return Repository(database.contactDao())

    }

}