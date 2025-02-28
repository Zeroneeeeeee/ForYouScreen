package com.example.foryouscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val selectedItem = remember { mutableStateOf(0) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Now in Android",
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }, navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            painterResource(R.drawable.ic_search),
                            "",
                            Modifier.size(24.dp)
                        )
                    }
                }, actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            painterResource(R.drawable.ic_profile_1),
                            "",
                            Modifier.size(24.dp)
                        )
                    }
                },
                colors = TopAppBarColors(
                    containerColor = Color.Transparent,
                    scrolledContainerColor = Color.Transparent,
                    navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface,
                    actionIconContentColor = MaterialTheme.colorScheme.onSurface,
                    subtitleContentColor = Color.Unspecified
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.background
            ) {
                NavigationBarItem(
                    selected = selectedItem.value == 0,
                    onClick = { selectedItem.value = 0 },
                    icon = {
                        if (selectedItem.value == 0) {
                            Icon(painterResource(R.drawable.ic_foryou_active), "")
                        }
                        Icon(painterResource(R.drawable.ic_foryou_inactive), "")
                    },
                    label = {
                        Text(
                            text = "For you",
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            style = MaterialTheme.typography.labelMedium
                        )
                    },
                    colors = NavigationBarItemColors(
                        selectedIconColor = if (isSystemInDarkTheme()) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onPrimaryContainer,
                        selectedTextColor = if (isSystemInDarkTheme()) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onPrimaryContainer,
                        selectedIndicatorColor = if (isSystemInDarkTheme()) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primaryContainer,
                        unselectedIconColor = MaterialTheme.colorScheme.onSurface,
                        unselectedTextColor = MaterialTheme.colorScheme.onSurface,
                        disabledIconColor =MaterialTheme.colorScheme.onSurface,
                        disabledTextColor = MaterialTheme.colorScheme.onSurface
                    ),
                )
                NavigationBarItem(
                    selected = selectedItem.value == 1,
                    onClick = { selectedItem.value = 1 },
                    icon = { Icon(painterResource(R.drawable.ic_episodes), "") },
                    label = {
                        Text(
                            "Episodes",
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                )
                NavigationBarItem(
                    selected = selectedItem.value == 2,
                    onClick = { selectedItem.value = 2 },
                    icon = { Icon(painterResource(R.drawable.ic_saved), "") },
                    label = { Text("Saved", color = MaterialTheme.colorScheme.onPrimaryContainer) }
                )
                NavigationBarItem(
                    selected = selectedItem.value == 3,
                    onClick = { selectedItem.value = 3 },
                    icon = {
                        Icon(painterResource(R.drawable.ic_interests), "")
                    },
                    label = {
                        Text(
                            "Interests",
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                )
            }
        }) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(MaterialTheme.colorScheme.inverseOnSurface, MaterialTheme.colorScheme.primaryContainer),
                        start = Offset(2000f, 0f),
                        end = Offset(0f, 3000f),
                    )
                )
        ) {
            Body(
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
