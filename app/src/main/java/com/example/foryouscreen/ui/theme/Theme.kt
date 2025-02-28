package com.example.foryouscreen.ui.theme

import androidx.compose.material3.MaterialTheme.shapes

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val customLightColorScheme = ColorScheme(
    primary = primary,      // Màu Primary
    onPrimary = on_primary,          // Màu chữ trên Primary
    primaryContainer = primary_container, // Màu container của Primary
    onPrimaryContainer = on_primary_container, // Màu chữ trên container của Primary
    inversePrimary = Color(0xFFBB86FC),
    secondary = secondary,    // Màu Secondary
    onSecondary = on_secondary,        // Màu chữ trên Secondary
    secondaryContainer = primary_container, // Màu container của Secondary
    onSecondaryContainer = on_secondary_container, // Màu chữ trên container của Secondary
    tertiary = tertiary,     // Màu Tertiary
    onTertiary = on_tertiary,         // Màu chữ trên Tertiary
    tertiaryContainer = tertiary_container, // Màu container của Tertiary
    onTertiaryContainer = on_tertiary_container, // Màu chữ trên container của Tertiary
    background = background,         // Màu nền
    onBackground = on_background,       // Màu chữ trên nền
    surface = surface,            // Màu surface
    onSurface = on_surface,          // Màu chữ trên surface
    surfaceVariant = surface_variant, // Màu nền phụ
    onSurfaceVariant = on_surface_variant,   // Màu chữ trên nền phụ
    surfaceTint = Color(0xFF6200EE),  // Màu tint của surface
    inverseSurface = inverse_surface,     // Màu surface ngược
    inverseOnSurface = inverse_on_surface,   // Màu chữ trên surface ngược
    error = error,                // Màu lỗi
    onError = on_error,            // Màu chữ trên lỗi
    errorContainer = error_container,
    onErrorContainer = on_error_container,
    outline = outline,             // Màu outline
    outlineVariant = Color.Unspecified,// Màu primary ngược
    scrim = Color.Unspecified,
    surfaceBright = Color.Unspecified,
    surfaceDim = Color.Unspecified,
    surfaceContainer = Color.Unspecified,
    surfaceContainerHigh = Color.Unspecified,
    surfaceContainerHighest = Color.Unspecified,
    surfaceContainerLow = Color.Unspecified,
    surfaceContainerLowest = Color.Unspecified,
)
val customDarkColorTheme = ColorScheme(
    primary = primary_dark,      // Màu Primary
    onPrimary = on_primary_dark,          // Màu chữ trên Primary
    primaryContainer = primary_container_dark, // Màu container của Primary
    onPrimaryContainer = on_primary_container_dark, // Màu chữ trên container của Primary
    inversePrimary = Color(0xFFBB86FC),
    secondary = secondary_dark,    // Màu Secondary
    onSecondary = on_secondary_dark,        // Màu chữ trên Secondary
    secondaryContainer = primary_container_dark, // Màu container của Secondary
    onSecondaryContainer = on_secondary_container_dark, // Màu chữ trên container của Secondary
    tertiary = tertiary_dark,     // Màu Tertiary
    onTertiary = on_tertiary_dark,         // Màu chữ trên Tertiary
    tertiaryContainer = tertiary_container_dark, // Màu container của Tertiary
    onTertiaryContainer = on_tertiary_container_dark, // Màu chữ trên container của Tertiary
    background = background_dark,         // Màu nền
    onBackground = on_background_dark,       // Màu chữ trên nền
    surface = surface_dark,            // Màu surface
    onSurface = on_surface_dark,          // Màu chữ trên surface
    surfaceVariant = surface_variant_dark, // Màu nền phụ
    onSurfaceVariant = on_surface_variant_dark,   // Màu chữ trên nền phụ
    surfaceTint = Color(0xFF6200EE),  // Màu tint của surface
    inverseSurface = inverse_surface_dark,     // Màu surface ngược
    inverseOnSurface = inverse_on_surface_dark,   // Màu chữ trên surface ngược
    error = error_dark,                // Màu lỗi
    onError = on_error_dark,            // Màu chữ trên lỗi
    errorContainer = error_container_dark,
    onErrorContainer = on_error_container_dark,
    outline = outline_dark,             // Màu outline
    outlineVariant = Color.Unspecified,// Màu primary ngược
    scrim = Color.Unspecified,
    surfaceBright = Color.Unspecified,
    surfaceDim = Color.Unspecified,
    surfaceContainer = Color.Unspecified,
    surfaceContainerHigh = Color.Unspecified,
    surfaceContainerHighest = Color.Unspecified,
    surfaceContainerLow = Color.Unspecified,
    surfaceContainerLowest = Color.Unspecified,
)

@Composable
fun SampleAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> customDarkColorTheme
        else -> customLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        shapes = shapes,
        content = content
    )
}