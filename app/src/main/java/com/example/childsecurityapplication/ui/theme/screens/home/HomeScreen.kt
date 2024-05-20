package com.example.childsecurityapplication.ui.theme.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.childsecurityapplication.navigation.ROUTE_HOMETRANSPORT
import com.example.childsecurityapplication.navigation.ROUTE_LOGIN
import com.example.childsecurityapplication.navigation.ROUTE_SCHOOLENTRIES
import com.example.childsecurityapplication.navigation.ROUTE_SCHOOLTRANSPORT
import com.example.childsecurityapplication.navigation.ROUTE_VIEWHOMETRANSPORT
import com.example.childsecurityapplication.navigation.ROUTE_VIEWSCHOOLENTRIES
import com.example.childsecurityapplication.navigation.ROUTE_VIEWSCHOOLTRANSPORT

@Composable
fun HomeScreen(navController: NavController) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context= LocalContext.current

        //var productdata= productviewmodel(navController,context)

        Text(text = "Your child's safety is our concern",
            color = Color.Cyan,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            navController.navigate(ROUTE_SCHOOLTRANSPORT)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "Fill in to School Transport Details")
        }
        Button(onClick = {
            navController.navigate(ROUTE_VIEWSCHOOLTRANSPORT)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "View to School Transport Details")
        }
        Spacer(modifier = Modifier.height(60.dp))

        Button(onClick = {
            navController.navigate(ROUTE_SCHOOLENTRIES)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "Fill in School Entries Details")
        }
        Button(onClick = {
            navController.navigate(ROUTE_VIEWSCHOOLENTRIES)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "View School Entries Details")
        }
        Spacer(modifier = Modifier.height(60.dp))

        Button(onClick = {
            navController.navigate(ROUTE_HOMETRANSPORT)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "Fill in to Home Transport Details")
        }
        Button(onClick = {
            navController.navigate(ROUTE_VIEWHOMETRANSPORT)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "View Home Transport Details")
        }
        Spacer(modifier = Modifier.height(60.dp))
        Button(onClick = {
            navController.navigate(ROUTE_LOGIN)
        }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Login")
        }


    }



}

@Preview
@Composable
private fun Homeprev() {
    HomeScreen(navController = rememberNavController())
}