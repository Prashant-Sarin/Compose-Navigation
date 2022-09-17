package com.sarindev.composenavigation.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

// Creating a composable
// function to display Top Bar
@ExperimentalMaterialApi
@Composable
fun MainContent() {
    Scaffold(
        content = { MyContent() }
    )
}

// Creating a composable function to
// create a Button and a Bottom Sheet
// Calling this function as content
// in the above function
@ExperimentalMaterialApi
@Composable
fun MyContent(){

    // Declaring a Boolean value to
    // store bottom sheet collapsed state
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(bottomSheetState =
    BottomSheetState(BottomSheetValue.Collapsed))

    // Declaing Coroutine scope
    val coroutineScope = rememberCoroutineScope()

    // Creating a Bottom Sheet
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent =  {
            Box(Modifier.fillMaxWidth().height(200.dp).background(Color(0XFF0F9D58))) {
                Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Hello Geek!", fontSize = 20.sp, color = Color.White)
                }
            }
        },
        sheetPeekHeight = 80.dp
    ){}

    Column(
        Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

        // Creating a button that changes
        // bottomSheetScaffoldState value upon click
        // when bottomSheetScaffoldState is collpased,
        // it expands and vice-versa
        Button(onClick = {
            coroutineScope.launch {
                if (bottomSheetScaffoldState.bottomSheetState.isCollapsed){
                    bottomSheetScaffoldState.bottomSheetState.expand()
                }else{
                    bottomSheetScaffoldState.bottomSheetState.collapse()
                }
            }
        }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))) {
            Text(text = "Click Me", color = Color.White)
        }
    }
}