package com.androidsrit.roomdb.data.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object: Migration(1,2){
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE Contact_table ADD COLUMN addedTime INTEGER NOT NULL DEFAULT 0")
    }
}