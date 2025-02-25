package com.example.foryouscreen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompactViewBody() {
    var expanded by remember { mutableStateOf(false) }
    val options = listOf("Newest first", "Option 2", "Option 3", "Option 4")
    var selectedOptionText by remember { mutableStateOf(options[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 140.dp)
    ) {
        Row(Modifier.fillMaxWidth()) {
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = it }
            ) {
                OutlinedTextField(
                    readOnly = true,
                    singleLine = true,
                    value = selectedOptionText,
                    textStyle = MaterialTheme.typography.labelSmall,
                    onValueChange = { selectedOptionText = it },
                    modifier = Modifier
                        .width(141.dp)
                        .height(50.dp)
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            shape = RoundedCornerShape(24.dp)
                        )
                        .clip(RoundedCornerShape(24.dp))
                        .background(Color(0xFF8C4190).copy(alpha = 0.15f)),
                    trailingIcon = {
                        Icon(painterResource(R.drawable.ic_dropdown), "")
                    },

                    )
                // Exposed dropdown menu
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    options.forEach { selectionOption ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    selectionOption,
                                    style = MaterialTheme.typography.bodyLarge
                                )
                            },
                            onClick = {
                                selectedOptionText = selectionOption
                                expanded = false
                            }
                        )
                    }
                }
            }
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    "Compact view",
                    style = MaterialTheme.typography.labelSmall
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Icon(painterResource(R.drawable.ic_short_text), "")
                Spacer(modifier = Modifier.padding(14.dp))
                Icon(painterResource(R.drawable.more_vert), "")
            }
        }
        Spacer(modifier = Modifier.padding(12.dp))
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painterResource(
                    R.drawable.ic_badge_3
                ),
                "",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                "updates since you last visit",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painterResource(R.drawable.ic_close),
                "",
                modifier = Modifier
                    .size(18.dp),
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        CardView(Modifier)
    }
}