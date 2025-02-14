package com.androidsrit.roomdb

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.androidsrit.roomdb.data.Repository
import com.androidsrit.roomdb.data.entity.Contact
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    val repository : Repository
):ViewModel(){
private var _state = MutableStateFlow<AppState>(AppState())
    val allContacts = repository.getAllContacts().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList<Contact>()
    )
    var state = combine(_state, allContacts){
        state, contacts ->
        state.copy(
            allContacts = contacts
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = AppState()
    )

fun insertContact(){
    val contact = Contact(
        name = state.value.name.value,
        phoneNumber = state.value.phone.value,
        email = state.value.email.value
    )

    viewModelScope.launch {
         repository.insertContact(contact)
    }
    state.value.name.value = ""
    state.value.phone.value = ""
    state.value.email.value = ""
}
}

data class AppState(
    var loading: Boolean= false,
    var error: String? = null,
    var allContacts: List<Contact> = emptyList<Contact>(),
    var name: MutableState<String> = mutableStateOf(""),
    var phone: MutableState<String> = mutableStateOf(""),
    var email: MutableState<String> = mutableStateOf("")


)