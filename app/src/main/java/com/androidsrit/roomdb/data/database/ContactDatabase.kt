package com.androidsrit.roomdb.data.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.DeleteColumn
import androidx.room.RenameColumn
import androidx.room.RenameTable
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import com.androidsrit.roomdb.data.entity.Contact

@Database(entities = [Contact::class],version = 5 , exportSchema = true,
//    autoMigrations = [
//        AutoMigration(
//            from = 1,
//            to = 2
//        ),
//        AutoMigration(
//            from = 2,
//            to = 3,
//            spec = ContactDatabase.RenameAddedAtToAddedTime::class
//        ),
//        AutoMigration(
//            from = 3,
//            to = 4,
//            spec = ContactDatabase.DeleteAddedTime::class
//        ),
////        AutoMigration(
////            from = 4,
////            to = 5,
////            spec = ContactDatabase.RenameContactTable::class
////        )
//    ]
)
abstract class ContactDatabase: RoomDatabase() {
    abstract  fun contactDao(): ContactDao

        @RenameColumn(tableName = "Contact", fromColumnName = "addedAt", toColumnName = "addedTime")
        class RenameAddedAtToAddedTime : AutoMigrationSpec
    @DeleteColumn(tableName = "Contact", columnName = "addedTime")
    class DeleteAddedTime : AutoMigrationSpec
    @RenameTable(fromTableName = "Contact", toTableName = "Contact_table")
    class RenameContactTable: AutoMigrationSpec

    }
