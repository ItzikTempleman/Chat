package com.example.whatssappmainactivitymock.project.screens.chat_screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.whatssappmainactivitymock.R

@Composable
fun TitleBar(
    title: String,
    modifier: Modifier = Modifier,
    textAlignment: TextAlign,
    arrangement: Arrangement.Horizontal,
    textSize: TextUnit,
) {
    Row(horizontalArrangement = arrangement, modifier = Modifier.fillMaxWidth()) {

        Text(
            text = title,
            modifier = modifier.padding(horizontal = 12.dp),
            textAlign = textAlignment,
            color = colorResource(R.color.black),
            fontSize = textSize,
            fontWeight = FontWeight.Bold
        )
    }
}