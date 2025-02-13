package com.androidsrit.roomdb.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.androidsrit.roomdb.data.entity.Contact

@Database(entities = [Contact::class],version = 1, exportSchema = false)
abstract class ContactDatabase: RoomDatabase() {
    abstract  fun contactDao(): ContactDao
//    companion object {
//     var db: ContactDatabase? = null
//
//
//    }
}