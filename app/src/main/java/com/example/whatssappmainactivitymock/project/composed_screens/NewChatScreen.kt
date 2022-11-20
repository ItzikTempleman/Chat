package com.example.whatssappmainactivitymock.project.composed_screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatssappmainactivitymock.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


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
        //  handleBoxState(scope,sheetState)


            BottomSheetScaffold(
                scaffoldState = scaffoldState,
                sheetContent = {

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(800.dp),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Column(modifier = Modifier.fillMaxWidth()
                                ) {

                                Title(
                                    title = stringResource(R.string.new_chat),
                                    textAlignment = TextAlign.Center,
                                    arrangement = Arrangement.Center,
                                    textSize = 18.sp
                                )
                                SearchField(modifier = Modifier)
                                ContactListLazyColumn()
                            }
                        }
                }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center,
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
                        Text(text = "Click")
                    }
                }
            }
        }
    }


    @ExperimentalMaterialApi
    fun handleBoxState(scope: CoroutineScope, sheetState: BottomSheetState) {
        scope.launch {
            if (sheetState.isCollapsed) {
                sheetState.expand()
            } else {
                sheetState.collapse()
            }
        }
    }


