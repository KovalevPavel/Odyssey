package ru.alexgladkov.common.compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.alexgladkov.common.compose.theme.Odyssey

@Composable
fun Toolbar(selectedTabIndex: Int) {
    Row(
        modifier = Modifier
            .background(color = Odyssey.color.secondaryBackground)
            .fillMaxWidth()
            .height(56.dp)
            .padding(
                horizontal = 16.dp,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "Toolbar title. Selected tab index $selectedTabIndex",
            fontSize = 21.sp,
            color = Odyssey.color.primaryText,
        )
    }
}
