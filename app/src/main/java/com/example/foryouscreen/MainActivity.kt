package com.example.foryouscreen

import android.health.connect.datatypes.Device
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.SampleAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SampleAppTheme {
                val selectedItem = remember { mutableStateOf(0) }
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        ,
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
                                actionIconContentColor = MaterialTheme.colorScheme.onSurface
                            )
                        )
                    },
                    bottomBar = {
                        BottomAppBar {
                            NavigationBarItem(
                                selected = selectedItem.value == 0,
                                onClick = { selectedItem.value = 0 },
                                icon = {
                                    Icon(painterResource(R.drawable.ic_foryou_inactive), "")
                                },
                                label = { Text("For you") }
                            )
                            NavigationBarItem(
                                selected = selectedItem.value == 1,
                                onClick = { selectedItem.value = 1 },
                                icon = { Icon(painterResource(R.drawable.ic_episodes), "") },
                                label = { Text("For you") }
                            )
                            NavigationBarItem(
                                selected = false,
                                onClick = {},
                                icon = { Icon(painterResource(R.drawable.ic_saved), "") },
                                label = { Text("For you") }
                            )
                            NavigationBarItem(
                                selected = false,
                                onClick = {},
                                icon = { Icon(painterResource(R.drawable.ic_interests), "") },
                                label = { Text("For you") }
                            )
                        }
                    }) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(Color(0xFFFAEEEF), Color(0xFFFFD6FA)),
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
        }
    }
}

@Composable
fun PeopleItems(
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier,
    name: String = "Ha"
) {
    Column {
        Box(
            modifier = Modifier
                .size(70.dp, 50.dp)

        ) {
            Box(
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .wrapContentSize()
                    .align(Alignment.BottomCenter)
            ) {
                Image(
                    painterResource(icon),
                    "",
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.BottomCenter)
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                )
            }
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(25.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Icon(
                    Icons.Default.Add,
                    "",
                    modifier = Modifier.background(Color.White, shape = CircleShape)
                )
            }
        }
        Text(
            name,
            modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun Body(modifier: Modifier = Modifier) {
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
            TopicItemData(R.drawable.ic_person, "Person 1"),
            TopicItemData(R.drawable.ic_person, "Person 2"),
            TopicItemData(R.drawable.ic_person, "Person 2"),
            TopicItemData(R.drawable.ic_person, "Person 2"),
            TopicItemData(R.drawable.ic_person, "Person 2"),
            TopicItemData(R.drawable.ic_person, "Person 2"),
            TopicItemData(R.drawable.ic_person, "Person 2"),
            TopicItemData(R.drawable.ic_person, "Person 2"),
            TopicItemData(R.drawable.ic_person, "Person 2"),
            TopicItemData(R.drawable.ic_person, "Person 2"),
            TopicItemData(R.drawable.ic_person, "Person 2"),
            TopicItemData(R.drawable.ic_person, "Person 2"),
            TopicItemData(R.drawable.ic_person, "Person 2"),
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

        Spacer(modifier = Modifier.padding(top = 24.dp))

        // Hiển thị các TopicItem với trạng thái isAdded được lưu trữ trong topicItems
        LazyHorizontalGrid(
            rows = GridCells.Fixed(3),
            modifier = Modifier
                .height(200.dp)
                .padding(start = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
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
                        if(item.name == "Accessibility"){
                            showCard = !showCard
                        }
                    },

                )

            }
        }

        Spacer(modifier = Modifier.padding(top = 24.dp))

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.inverseSurface),
            enabled = isAnyItemSelected
        ) {
            Text("Done")
        }
        if(showCard) {
            CardView()
        }
    }
}

@Composable
fun TopicItems(
    @DrawableRes icon: Int,
    name: String,
    isAdded: Boolean,
    onButtonStateChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .size(width = 264.dp, height = 56.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Image(
            painterResource(icon),
            "",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 12.dp)
                .size(32.dp),
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
        )
        Spacer(modifier = Modifier.padding(3.dp))
        Text(
            name,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 5.dp),
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = {
                // Thay đổi trạng thái khi nhấn
                onButtonStateChange(!isAdded)
            },
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .clip(CircleShape)
                .size(25.dp)
        ) {
            if (isAdded) {
                Icon(
                    Icons.Default.Done,
                    "",
                    Modifier
                        .size(24.dp)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                )
            } else {
                Icon(
                    Icons.Default.Add,
                    "",
                    Modifier.size(24.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(7.dp))
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_7_PRO)
@Composable
fun CardView() {
    Column(
        modifier = Modifier
            .fillMaxWidth() // Đảm bảo Column chiếm toàn bộ chiều rộng
            .padding(16.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Image(
            painter = painterResource(R.drawable.compose_image),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop// Đảm bảo ảnh fill hết chiều rộng
        )

        // Các phần tử khác trong Column (Row, Box)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 12.dp, end = 16.dp)
        ) {
            Image(
                painterResource(R.drawable.ic_launcher_background),
                contentDescription = "",
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
            )
            Text(
                "Author",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
            )
        }

        Box(
            Modifier
                .fillMaxWidth() // Đảm bảo Box chiếm toàn bộ chiều rộng
                .padding(vertical = 12.dp, horizontal = 16.dp)
        ) {
            Text(
                "New Compose for Wear OS codelab",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(end = 48.dp)
            )

            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(40.dp)
                    .background(MaterialTheme.colorScheme.primaryContainer, CircleShape)
                    .clip(CircleShape)
                    .align(Alignment.CenterEnd)
            ) {
                Icon(
                    painterResource(R.drawable.ic_bookmark),
                    contentDescription = "",
                    modifier = Modifier.size(18.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Image(
                painterResource(R.drawable.ic_dot),
                contentDescription = "",
                modifier = Modifier
                    .size(8.dp)
                    .align(Alignment.CenterVertically)
            )
            Text(
                "January 1, 2021",
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )
            Text(
                "developer.android.com",
                style = MaterialTheme.typography.labelSmall,
            )
        }

        Text(
            "In this codelab, you can learn how Wear OS can work with Compose, what Wear OS specific composables are available, and more!",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
        )
    }
    LazyRow(){

    }
}


@Preview(showBackground = true, device = Devices.PIXEL_7_PRO)
@Composable
fun GreetingPreview() {
    SampleAppTheme {
        Column {
            Body()

        }
    }
}