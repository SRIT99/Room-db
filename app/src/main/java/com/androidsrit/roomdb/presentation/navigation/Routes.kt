package com.androidsrit.roomdb.presentation.navigation
import kotlinx.serialization.Serializable
sealed class Routes {
    @Serializable
    object HomeScreen
    @Serializable
    object AddEditScreen
}