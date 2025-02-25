package com.example.foryouscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.foryouscreen.common.TopicItemData

@Composable
fun Body(modifier: Modifier) {
    val navController = rememberNavController()
    // Tạo NavHost với các màn hình
    NavHost(navController = navController, startDestination = "body") {
        composable("body") { BodyContent(modifier, navController) }
        composable("compact_view") { CompactViewBody() }
    }
}

@Composable
fun BodyContent(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val peopleItems = remember {
        mutableStateListOf(
            TopicItemData(R.drawable.ic_person, "Fernando"),
            TopicItemData(R.drawable.ic_person, "Alex"),
            TopicItemData(R.drawable.ic_person, "Sam"),
            TopicItemData(R.drawable.ic_person, "Lee"),
            TopicItemData(R.drawable.ic_person, "Ping"),
            TopicItemData(R.drawable.ic_person, "Anna"),
            TopicItemData(R.drawable.ic_person, "Marty"),
            TopicItemData(R.drawable.ic_person, "Daniel"),
            // Thêm các item khác ở đây
        )
    }

    // Tạo danh sách các TopicItemData với trạng thái isAdded
    val topicItems = remember {
        mutableStateListOf(
            TopicItemData(R.drawable.ic_accessibility, "Accessibility"),
            TopicItemData(R.drawable.ic_android_auto, "Android Auto"),
            TopicItemData(R.drawable.ic_android_studio, "Android Studio"),
            TopicItemData(R.drawable.ic_android_tv, "Android TV"),
            TopicItemData(R.drawable.ic_architecture, "Architecture"),
            TopicItemData(R.drawable.ic_compose, "Compose"),
            // Thêm các item khác ở đây
        )
    }

    var showCard by remember { mutableStateOf(false) }
    val isAnyItemSelected = topicItems.any { it.isAdded }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(
                state = rememberScrollState()
            )
    ) {
        Spacer(modifier = Modifier.padding(top = 24.dp))
        Text(
            "What are you interested in?",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp, 0.dp),
            style = MaterialTheme.typography.titleMedium.copy(textAlign = TextAlign.Center)
        )
        Spacer(modifier = Modifier.padding(top = 24.dp))
        Text(
            text = "Updates from interests you follow will appear here. Follow some things to get started.",
            modifier = Modifier
                .padding(24.dp, 0.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.padding(top = 24.dp))

        // Hiển thị danh sách PeopleItems (dữ liệu mẫu)
        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(peopleItems) { item -> // Giả sử bạn muốn hiển thị 10 item
                Spacer(modifier = Modifier.padding(start = 10.dp))
                PeopleItems(
                    icon = item.icon,
                    name = item.name
                )
                Spacer(modifier = Modifier.padding(end = 10.dp))
            }
        }

        Spacer(modifier = Modifier.padding(16.dp))

        // Hiển thị các TopicItem với trạng thái isAdded được lưu trữ trong topicItems
        LazyHorizontalGrid(
            contentPadding = PaddingValues(8.dp),
            rows = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(topicItems) { item ->
                TopicItems(
                    icon = item.icon,
                    name = item.name,
                    isAdded = item.isAdded,
                    onButtonStateChange = { newState ->
                        // Cập nhật trạng thái của từng item trong danh sách
                        val updatedItem =
                            item.copy(isAdded = newState) // Tạo đối tượng mới với isAdded mới
                        topicItems[topicItems.indexOf(item)] = updatedItem
                        if (item.name == "Accessibility") {
                            showCard = !showCard
                        }
                    },
                )
            }
        }

        Spacer(modifier = Modifier.padding(top = 24.dp))

        Button(
            onClick = {
                navController.navigate("compact_view")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.inverseSurface),
            enabled = isAnyItemSelected
        ) {
            Text("Done")
        }

        Spacer(modifier = Modifier.padding(12.dp))
        Text(
            "Browse topics",
            style = MaterialTheme.typography.labelSmall.copy(textAlign = TextAlign.Center),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)

        )
        Spacer(modifier = Modifier.padding(12.dp))
        if (showCard) {
            CardView(Modifier.padding(16.dp))
        }
    }
}
