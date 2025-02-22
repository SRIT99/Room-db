package com.androidsrit.roomdb.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Address(
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null,
    val address: String,
    val contactId: Int
)
