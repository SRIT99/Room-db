package com.androidsrit.roomdb.presentation.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.androidsrit.roomdb.data.database.ContactAddress
import com.androidsrit.roomdb.presentation.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenUI(
    modifier: Modifier = Modifier,
    state: AppState = AppState(),
    vm: ContactViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
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
                .fillMaxSize(),
        ) {
            items(state.allContacts) {

                Spacer(modifier = Modifier.height(5.dp))
                ContactItemUi(contactAddress = it, vm, navController)
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContactItemUi(contactAddress: ContactAddress, vm: ContactViewModel, navController: NavHostController) {
    val isExpanded = remember{
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp)
            .combinedClickable(
                onClick = {
                    isExpanded.value = !isExpanded.value
                },
                onDoubleClick = {},
                onLongClick = {
                    vm.state.value.id.value = contactAddress.contact.id
                    vm.state.value.name.value = contactAddress.contact.name
                    vm.state.value.phone.value = contactAddress.contact.phoneNumber
                    vm.state.value.email.value = contactAddress.contact.email
                    navController.navigate(Routes.AddEditScreen)
                }
            ), shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFCDC1FF)

    )){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = contactAddress.contact.name, style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = contactAddress.contact.phoneNumber,
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Text(text = contactAddress.contact.email, fontSize = 16.sp,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimary)
                   AnimatedVisibility(visible = isExpanded.value){
                    Text(text = contactAddress.address.address, fontSize = 16.sp)
                   }
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Rounded.Delete,
                contentDescription = null,
                modifier = Modifier.clickable {
                    vm.state.value.id.value = contactAddress.contact.id
                    vm.state.value.name.value = contactAddress.contact.name
                    vm.state.value.phone.value = contactAddress.contact.phoneNumber
                    vm.state.value.email.value = contactAddress.contact.email
                    vm.deleteContact()
                },
                tint = MaterialTheme.colorScheme.onPrimary
            )
        }

    }
}
