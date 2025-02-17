package com.androidsrit.roomdb.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name : String,
    var phoneNumber: String,
    var email: String,
    @ColumnInfo("addedTime", defaultValue = "0")
    var addedTime: Long = System.currentTimeMillis()
)