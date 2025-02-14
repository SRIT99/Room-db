package com.androidsrit.roomdb.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.androidsrit.roomdb.AppState
import com.androidsrit.roomdb.R

@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showSystemUi = true, showBackground = true)
@Composable
fun AddEditScreenUI(
    modifier: Modifier = Modifier,
    onEvent: () -> Unit = {},
    state: AppState = AppState(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Add Contact")
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                null,
                modifier = Modifier
                    .size(250.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = state.name.value,
                onValueChange = {state.name.value = it},
                placeholder = { Text("Contact's Name") },
                label = {
                    Text(text = "Name")
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = state.phone.value,
                onValueChange = {state.phone.value = it},
                placeholder = { Text("Phone Number") },
                label = {
                    Text(text = "Phone Number")
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = state.email.value,
                onValueChange = {state.email.value = it},
                placeholder = { Text("Contact's Email") },
                label = {
                    Text(text = "Email")
                }
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = {
                    onEvent.invoke()
                    navController.navigateUp()
                },
                modifier = Modifier
                .fillMaxWidth()
                .padding(60.dp)) {
                Text(text = "Save")
            }
        }

    }

}