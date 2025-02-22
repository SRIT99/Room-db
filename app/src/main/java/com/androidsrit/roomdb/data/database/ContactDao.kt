package com.androidsrit.roomdb.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import androidx.room.Upsert
import com.androidsrit.roomdb.data.entity.Address
import com.androidsrit.roomdb.data.entity.Contact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Upsert
    suspend fun upsertContact(contact: Contact):Long

    @Delete
   suspend fun deleteContact(contact: Contact)

    @Update
    fun updateContact(contact: Contact)

    @Query("SELECT * FROM Contact_table")
    fun getAllContacts(): Flow<List<Contact>>

    @Upsert
    suspend fun upsertAddress(address: Address)

    @Query("SELECT * FROM Address")
    fun getAllAddress(): Flow<List<Address>>

    @Transaction
    suspend fun insertContactWithAddress(contact: Contact, address: Address) {
        val contactId = upsertContact(contact).toInt()
        val updatedAddress = address.copy(contactId = contactId)
        upsertAddress(updatedAddress)
    }
}