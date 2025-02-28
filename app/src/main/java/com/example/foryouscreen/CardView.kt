package com.example.foryouscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun CardView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth() // Đảm bảo Column chiếm toàn bộ chiều rộng
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
            Icon(
                painterResource(R.drawable.ic_dot),
                contentDescription = "",
                modifier = Modifier
                    .size(8.dp)
                    .align(Alignment.CenterVertically),
                tint = MaterialTheme.colorScheme.primary
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
        Box(
            Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, bottom = 16.dp, end = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 48.dp)
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Button(
                    onClick = {},
                    enabled = false
                ) {
                    Text("Topic")
                }
                Button(
                    onClick = {},
                    enabled = true,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.run {
                            if (isSystemInDarkTheme()) primary else primaryContainer
                        }
                    )
                ) {
                    Text("Compose",
                        color = MaterialTheme.colorScheme.run {
                            if (isSystemInDarkTheme()) onPrimary else onPrimaryContainer
                        }
                    )
                }
                Button(
                    onClick = {},
                    enabled = false
                ) {
                    Text("Events")
                }
                Button(
                    onClick = {},
                    enabled = false,

                    ) {
                    Text("Performance")
                }
                Button(
                    onClick = {},
                    enabled = false
                ) {
                    Text("Topic")
                }
            }
            Icon(
                painterResource(
                    R.drawable.more_vert
                ),
                "",
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(7.dp)
            )
        }
    }
}
