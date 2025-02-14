package com.androidsrit.roomdb.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.androidsrit.roomdb.ContactViewModel
import com.androidsrit.roomdb.presentation.screens.AddEditScreenUI

@Composable
fun AppNavigation(modifier: Modifier = Modifier, vm : ContactViewModel = hiltViewModel()) {
    var navController = rememberNavController()
    val state = vm.state.collectAsState()

    NavHost(navController = navController, startDestination = Routes.HomeScreen) {
        composable<Routes.HomeScreen> {
            Box(modifier = Modifier.fillMaxSize()){
                Button(
                    onClick = {
                        navController.navigate(Routes.AddEditScreen)
                    }
                ){
                    Text(text = "Add Contact")
                }
            }
        }
        composable<Routes.AddEditScreen> {
            AddEditScreenUI(modifier = Modifier, onEvent = {vm.insertContact()}, state = state.value)
        }

    }
}