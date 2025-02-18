package com.androidsrit.roomdb.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.androidsrit.roomdb.data.entity.Contact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Upsert
    suspend fun upsertContact(contact: Contact)

    @Delete
   suspend fun deleteContact(contact: Contact)

    @Update
    fun updateContact(contact: Contact)

    @Query("SELECT * FROM Contact_table")
    fun getAllContacts(): Flow<List<Contact>>
}