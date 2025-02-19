package com.androidsrit.roomdb.ui.theme

import android.app.Activity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF1E1E1E), // Dark Grey
    secondary = Color(0xFF303030), // Medium Dark Grey
    tertiary = Color(0xFF64B5F6), // Blue
    background = Color(0xFF121212), // Almost Black
    surface = Color(0xFF1E1E1E), // Dark Grey
    onPrimary = Color(0xFFE0E0E0), // Light Grey
    onSecondary = Color(0xFFB0B0B0), // Medium Light Grey
    onTertiary = Color(0xFFBBDEFB), // Light Blue
    onBackground = Color(0xFFE0E0E0), // Light Grey
    onSurface = Color(0xFFE0E0E0) // Light Grey
)
private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFFAFAFA), // Off-White
    secondary = Color(0xFFE0E0E0), // Medium Grey
    tertiary = Color(0xFFBBDEFB), // Light Blue
    background = Color(0xFFFFFFFF), // White
    surface = Color(0xFFF5F5F5), // Light Grey
    onPrimary = Color(0xFF212121), // Dark Grey
    onSecondary = Color(0xFF757575), // Light Grey
    onTertiary = Color(0xFF1976D2), // Blue
    onBackground = Color(0xFF212121), // Dark Grey
    onSurface = Color(0xFF212121)
)

val LightTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 57.sp,
        color = Color(0xFF1976D2) // Blue for light theme
    ),
    displayMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 45.sp,
        color = Color(0xFF1976D2) // Blue for light theme
    ),
    displaySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        color = Color(0xFF1976D2) // Blue for light theme
    ),
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        color = Color(0xFF212121) // Dark Grey for light theme
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        color = Color(0xFF212121) // Dark Grey for light theme
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = Color(0xFF212121) // Dark Grey for light theme
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        color = Color(0xFF212121) // Dark Grey for light theme
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = Color(0xFF757575) // Light Grey for light theme
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = Color(0xFF757575) // Light Grey for light theme
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Color(0xFF212121) // Dark Grey for light theme
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color(0xFF212121) // Dark Grey for light theme
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = Color(0xFF212121) // Dark Grey for light theme
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = Color(0xFF757575) // Light Grey for light theme
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        color = Color(0xFF757575) // Light Grey for light theme
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        color = Color(0xFF757575) // Light Grey for light theme
    )
)

val DarkTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 57.sp,
        color = Color(0xFFBBDEFB) // Light Blue for dark theme
    ),
    displayMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 45.sp,
        color = Color(0xFFBBDEFB) // Light Blue for dark theme
    ),
    displaySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        color = Color(0xFFBBDEFB) // Light Blue for dark theme
    ),
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        color = Color(0xFFE0E0E0) // Light Grey for dark theme
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        color = Color(0xFFE0E0E0) // Light Grey for dark theme
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = Color(0xFFE0E0E0) // Light Grey for dark theme
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        color = Color(0xFFE0E0E0) // Light Grey for dark theme
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = Color(0xFFB0B0B0) // Medium Light Grey for dark theme
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = Color(0xFFB0B0B0) // Medium Light Grey for dark theme
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        color = Color(0xFFE0E0E0) // Light Grey for dark theme
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color(0xFFE0E0E0) // Light Grey for dark theme
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        color = Color(0xFFE0E0E0) // Light Grey for dark theme
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = Color(0xFFB0B0B0) // Medium Light Grey for dark theme
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        color = Color(0xFFB0B0B0) // Medium Light Grey for dark theme
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        color = Color(0xFFB0B0B0) // Medium Light Grey for dark theme
    )
)


@Composable
fun RoomdbTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)

        }

        darkTheme->DarkColorScheme
        else -> LightColorScheme
    }
    var typography = when{

       darkTheme -> DarkTypography
        else -> LightTypography
    }




    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        content = content
    )
}