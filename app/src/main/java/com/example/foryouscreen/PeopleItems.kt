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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

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
                    painterResource(R.drawable.ic_add),
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
