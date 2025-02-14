package com.androidsrit.roomdb.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
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
                .background(Color(0xFF4F571D)),
        ) {
            items(state.allContacts) {

                Spacer(modifier = Modifier.height(5.dp))
                ContactItemUi(contact = it, vm)
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}

@Composable
fun ContactItemUi(contact: Contact, vm: ContactViewModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth() .padding(start = 5.dp, end = 5.dp)
            .clickable { }, shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2A2828)
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
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Rounded.Delete,
                contentDescription = null,
                modifier = Modifier.clickable {
                    vm.state.value.id.value = contact.id
                    vm.state.value.name.value = contact.name
                    vm.state.value.phone.value = contact.phoneNumber
                    vm.state.value.email.value = contact.email
                    vm.deleteContact()
                }
            )
        }
    }
}
