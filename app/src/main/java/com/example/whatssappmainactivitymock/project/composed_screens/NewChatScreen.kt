package com.example.whatssappmainactivitymock.project.composed_screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatssappmainactivitymock.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


@ExperimentalMaterialApi
@Composable
fun BottomSheetDialogPopUp(isExpanded: Boolean) {


    if (isExpanded) {
        val sheetState = rememberBottomSheetState(
            initialValue = BottomSheetValue.Collapsed
        )
        val scaffoldState = rememberBottomSheetScaffoldState(
            bottomSheetState = sheetState
        )
        val scope = rememberCoroutineScope()
        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetContent = {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Bottom sheet",
                        fontSize = 60.sp
                    )
                }
            },
            sheetBackgroundColor = Color.Gray,
            sheetPeekHeight = 0.dp
        ) {
            Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Button(onClick = {
                        scope.launch {
                            if (sheetState.isCollapsed) {
                                sheetState.expand()
                            } else {
                                sheetState.collapse()
                            }
                        }
                    }) {
                        //Text(text = "Bottom sheet fraction: ${sheetState.progress.fraction}")
                        Text(text = "Click")
                    }
                }
        }
    }
}



@Composable
fun NewChat() {
    Column(modifier = Modifier.fillMaxSize()) {
        Title(title = stringResource(R.string.new_chat))
    }
}

