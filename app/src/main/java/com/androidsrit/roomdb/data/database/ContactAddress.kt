package com.androidsrit.roomdb.data.database

import androidx.room.Embedded
import androidx.room.Relation
import com.androidsrit.roomdb.data.entity.Address
import com.androidsrit.roomdb.data.entity.Contact

data class ContactAddress(
    @Embedded
    val contact: Contact,
    @Relation(
        parentColumn = "id",
        entityColumn = "contactId"
    )
    val address: Address

)