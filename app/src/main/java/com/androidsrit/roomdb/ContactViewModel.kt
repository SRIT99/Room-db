package com.androidsrit.roomdb

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.androidsrit.roomdb.data.Repository
import com.androidsrit.roomdb.data.entity.Contact
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class ContactViewModel @Inject constructor(
    val repository : Repository
):ViewModel(){
private var _state = MutableStateFlow<AppState>(AppState())
    var state = _state.asStateFlow()


}

class AppState(
    var loading: Boolean= false,
    var error: String? = null,
    var allContacts: List<Contact> = emptyList<Contact>(),
    var name: MutableState<String> = mutableStateOf(""),
    var phone: MutableState<String> = mutableStateOf(""),
    var email: MutableState<String> = mutableStateOf("")


)