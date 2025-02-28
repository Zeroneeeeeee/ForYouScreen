package com.example.foryouscreen.ui.theme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// primary
val primary = Color(0xFF8B418F)
val on_primary = Color.White
val primary_container = Color(0xFFFFD6FA)
val on_primary_container = Color(0xFF36003C)

val on_surface = Color(0xFF201A1B)
val surface = Color(0xFFFCFCFC)
val on_surface_variant = Color(0xFF4D444C)
val surface_variant = Color(0xFFEDDEE8)
val inverse_on_surface = Color(0xFFFAEEEF)
val inverse_surface = Color(0xFF362F30)

// background
val on_background = Color(0xFF201A1B)
val background = Color(0xFFFCFCFC)
val outline = Color(0xFF7F747C)

// secondary
val secondary = Color(0xFFA23F16)
val on_secondary = Color.White
val secondary_container = Color(0xFFFFDBCF)
val on_secondary_container = Color(0xFF380D00)

// tertiary
val tertiary = Color(0xFF006780)
val on_tertiary = Color.White
val tertiary_container = Color(0xFFB8EAFF)
val on_tertiary_container = Color(0xFF001F28)

// error
val error = Color(0xFFBA1A1A)
val on_error = Color.White
val error_container = Color(0xFFFFDAD6)
val on_error_container = Color(0xFF410002)

val surface2_light = lightColorScheme(
    primary = Color(0x148B418F), // Màu có độ trong suốt 8%
    secondary = Color(0xFFFFFBFF)  // Màu trắng ngà
)

// dark color

// primary
val primary_dark = Color(0xFFFFA9FE)
val on_primary_dark = Color(0xFF560A5D)
val primary_container_dark = Color(0xFF702776)
val on_primary_container_dark = primary_container

val on_surface_dark = Color(0xFFECDFE0)
val surface_dark = on_surface
val on_surface_variant_dark = Color(0xFFD0C3CC)
val surface_variant_dark = on_surface_variant
val inverse_on_surface_dark = on_background
val inverse_surface_dark = Color(0xFFECDFE0)

// background
val on_background_dark = inverse_surface_dark
val background_dark = on_background
val outline_dark = Color(0xFF998D96)

// secondary
val secondary_dark = Color(0xFFFFB59B)
val on_secondary_dark = Color(0xFF5B1A00)
val secondary_container_dark = Color(0xFF812800)
val on_secondary_container_dark = secondary_container

// tertiary
val tertiary_dark = Color(0xFF5DD5FC)
val on_tertiary_dark = Color(0xFF003544)
val tertiary_container_dark = Color(0xFF004D61)
val on_tertiary_container_dark = tertiary_container

// error
val error_dark = Color(0xFFFFB4AB)
val on_error_dark = Color(0xFFFFB4AB)
val error_container_dark = Color(0xFF93000A)
val on_error_container_dark = error_container
