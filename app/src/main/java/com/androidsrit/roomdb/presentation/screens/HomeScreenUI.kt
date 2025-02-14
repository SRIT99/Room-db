package com.androidsrit.roomdb.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.androidsrit.roomdb.AppState
import com.androidsrit.roomdb.ContactViewModel
import com.androidsrit.roomdb.data.entity.Contact
import com.androidsrit.roomdb.presentation.navigation.Routes

@Composable
fun HomeScreenUI(
    modifier: Modifier = Modifier,
    state: AppState = AppState(),
    vm: ContactViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold (
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Routes.AddEditScreen) }
            ) {
                Icon(Icons.Rounded.Add, null)
            }
        }
    ) {
        it
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
        ) {
            items(state.allContacts) {
                ContactItemUi(contact = it)
            }
        }
    }
}

@Composable
fun ContactItemUi(contact: Contact) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }, shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xfff2f2f2)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Column{
                Text(text = contact.name, fontSize = 20.sp)
                Text(text = contact.phoneNumber, fontSize = 16.sp)
                Text(text = contact.email, fontSize = 16.sp)
            }
        }
    }
}
