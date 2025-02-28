package com.example.foryouscreen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun PeopleItems(
    @DrawableRes icon: Int =0,
    modifier: Modifier = Modifier,
    name: String = "Ha"
) {
    Column {
        Box(
            modifier = Modifier
                .size(70.dp, 50.dp)

        ) {
            val color1 = MaterialTheme.colorScheme.primary // Màu đầu tiên
            val color2 = MaterialTheme.colorScheme.secondary // Màu thứ hai

            // Tạo màu pha trộn giữa 2 màu có sẵn
            val blendedColor = Brush.linearGradient(
                colors = listOf(color1, color2), // Nâu đỏ -> Tím
                start = Offset(0f, 0f),
                end = Offset(100f, 100f)
            )
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.BottomCenter)
                    .clip(shape = CircleShape)
                    .background(MaterialTheme.colorScheme.surfaceVariant)

            ) {
                Icon(
                    painterResource(icon),
                    "",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(40.dp)
                        .graphicsLayer(alpha = 0.99f) // Bắt buộc để gradient hoạt động
                        .drawWithCache {
                            onDrawWithContent {
                                drawContent()
                                drawRect(blendedColor, blendMode = BlendMode.SrcAtop) // Áp gradient
                            }
                        }
                )
            }
            IconButton(
                onClick = {},
                modifier = Modifier
                    .size(25.dp)
                    .align(Alignment.BottomEnd)
            ) {
                Icon(
                    painterResource(R.drawable.ic_add),
                    "",
                    modifier = Modifier.background(MaterialTheme.colorScheme.surface, shape = CircleShape)
                )
            }
        }
        Text(
            name,
            modifier.align(Alignment.CenterHorizontally)
        )
    }
}
