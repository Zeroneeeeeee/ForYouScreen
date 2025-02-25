package com.example.foryouscreen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
                .size(25.dp)
        ) {
            if (isAdded) {
                Icon(
                    painterResource(R.drawable.ic_done),
                    "",
                    Modifier
                        .size(24.dp)
                        .background(MaterialTheme.colorScheme.primaryContainer)
                )
            } else {
                Icon(
                    painterResource(R.drawable.ic_add),
                    "",
                    Modifier.size(24.dp)
                )
            }
        }
        Spacer(modifier = Modifier.padding(7.dp))
    }
}
