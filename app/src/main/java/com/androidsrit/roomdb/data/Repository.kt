package com.androidsrit.roomdb.data

import com.androidsrit.roomdb.data.database.ContactDao
import com.androidsrit.roomdb.data.entity.Contact

class Repository(
    private val contactDao:ContactDao
) {
    suspend fun insertContact(contact: Contact)= contactDao.insertContact(contact)
    fun updateContact(contact: Contact) = contactDao.updateContact(contact)
  fun deleteContact(contact: Contact) = contactDao.deleteContact(contact)
   fun getAllContacts() = contactDao.getAllContacts()

}