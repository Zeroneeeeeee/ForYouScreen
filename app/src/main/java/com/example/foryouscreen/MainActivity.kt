package com.example.foryouscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.foryouscreen.ui.theme.ForYouScreenTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ForYouScreenTheme {
                val selectedItem = remember { mutableStateOf(0) }
                Scaffold(topBar = {
                    TopAppBar(title = {
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Now in Android",
                                style = MaterialTheme.typography.titleLarge,
                            )
                        }
                    }, navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(painterResource(R.drawable.ic_search), "")
                        }
                    },
                        actions = {
                            IconButton(onClick = {}) {
                                Icon(painterResource(R.drawable.ic_profile_1),"")
                            }
                        })
                },
                    bottomBar = {
                        BottomAppBar {
                            NavigationBarItem(
                                selected = selectedItem.value == 0,
                                onClick = {selectedItem.value = 0},
                                icon = {
                                    Icon(painterResource(R.drawable.ic_foryou_inactive), "")
                                },
                                label = {Text("For you")}
                            )
                            NavigationBarItem(
                                selected = selectedItem.value == 1,
                                onClick = {selectedItem.value = 1},
                                icon = { Icon(painterResource(R.drawable.ic_episodes),"")},
                                label = {Text("For you")}
                            )
                            NavigationBarItem(
                                selected = false,
                                onClick = {},
                                icon = { Icon(painterResource(R.drawable.ic_saved),"")},
                                label = {Text("For you")}
                            )
                            NavigationBarItem(
                                selected = false,
                                onClick = {},
                                icon = { Icon(painterResource(R.drawable.ic_interests),"")},
                                label = {Text("For you")}
                            )
                        }
                    }) { innerPadding ->
                    Body(
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}



@Composable
fun PeopleItems(
    @DrawableRes icon:Int,
    modifier: Modifier = Modifier,
    name:String = "Ha"
){
    Column {
        Box(
            modifier = Modifier.size(70.dp, 50.dp)
        ) {
            Image(
                painterResource(icon),
                "",
                modifier = Modifier
                    .background(color = Color.Red, shape = CircleShape)
                    .size(50.dp)
                    .align(Alignment.BottomCenter)
            )
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(25.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Icon(
                    Icons.Default.Add,
                    "",
                    modifier = Modifier.background(Color.Gray, shape = CircleShape)
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ){
        Text("What are you interested in?")
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Text(
            text = "Updates from interests you follow will appear here. Follow some things to get started.",
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth()
        ){
            items(10) { index -> // Giả sử bạn muốn hiển thị 10 item
                PeopleItems(
                    icon = R.drawable.ic_person, // Thay đổi với hình ảnh bạn muốn hiển thị
                    name = "Person #$index"
                )
            }
        }
        LazyHorizontalGrid(
            rows = GridCells.Fixed(3),
            modifier=Modifier.height(200.dp)
                .padding(start = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(10) { index ->
                TopicItems(
                    icon = R.drawable.ic_person,
                    name = "Person #$index"
                )
            }
        }
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Button(onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)) {
            Text("Done")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun TopicItems(
    @DrawableRes icon:Int = R.drawable.ic_person,
    name:String = "Accessibility"
){
    Row(modifier = Modifier
        .size(width = 250.dp, height = 60.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(Color.LightGray)

    ){
        Icon(
            painterResource(icon),
            "",
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 5.dp)
                .size(50.dp)
        )
        Text(name,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 5.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = {},
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Icon(Icons.Default.Add,
                ""
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ForYouScreenTheme {
        Body()
    }
}