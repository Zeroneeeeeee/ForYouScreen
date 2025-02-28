package com.example.foryouscreen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
                .size(25.dp),
        ) {
            val color1 : Color
            val color2 : Color

            if(isSystemInDarkTheme()){
                color1 = if(!isAdded) Color.Transparent else MaterialTheme.colorScheme.primary
                color2 = if(!isAdded) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.onPrimary
            }
            else {
                color1 = if(!isAdded) Color.Transparent else MaterialTheme.colorScheme.primaryContainer
                color2 = if(!isAdded) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.onSurfaceVariant
            }

            Box(
                modifier = Modifier
                    .size(35.dp) // Điều chỉnh kích thước background
                    .background(color1, CircleShape), // Màu nền lớn hơn icon
                contentAlignment = Alignment.Center // Căn giữa icon trong nền
            ) {
                Icon(
                    painter = painterResource(if (isAdded) R.drawable.ic_done else R.drawable.ic_add),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp), // Kích thước icon nhỏ hơn background
                    tint = color2
                )
            }
        }
        Spacer(modifier = Modifier.padding(7.dp))
    }
}
