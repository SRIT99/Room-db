package com.androidsrit.roomdb.data.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import com.androidsrit.roomdb.data.entity.Contact

@Database(entities = [Contact::class],version = 3, exportSchema = true,
    autoMigrations = [
        AutoMigration(
            from = 1,
            to = 2
        ),
        AutoMigration(
            from = 2,
            to = 3,
            spec = ContactDatabase.RenameAddedAtToAddedTime::class
        )]
)
abstract class ContactDatabase: RoomDatabase() {
    abstract  fun contactDao(): ContactDao

        @RenameColumn(tableName = "Contact", fromColumnName = "addedAt", toColumnName = "addedTime")
        class RenameAddedAtToAddedTime : AutoMigrationSpec

    }
