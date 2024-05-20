package com.example.childsecurityapplication.ui.theme.screens.homeTransport

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.childsecurityapplication.data.homeTransportviewmodel
import com.example.childsecurityapplication.data.schoolTransportviewmodel
import com.example.childsecurityapplication.model.HomeTransport
import com.example.childsecurityapplication.model.SchoolTransport
import com.example.childsecurityapplication.navigation.ROUTE_HOMETRANSPORT
import com.example.childsecurityapplication.navigation.ROUTE_SCHOOLTRANSPORT

@Composable
fun ViewHomeTransportScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var homeTransportRepository = homeTransportviewmodel(navController, context)
        val emptyHomeTransportState = remember { mutableStateOf(HomeTransport("","","","","")) }
        var emptyHomeTransportListState = remember { mutableStateListOf<HomeTransport>() }

        var homeTransports = homeTransportRepository.viewHomeTransports(emptyHomeTransportState, emptyHomeTransportListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All products",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(homeTransports){
                    HomeTransportItem(
                        name = it.name,
                        time = it.time,
                        busnumber = it.busnumber,
                        drivername = it.drivername,
                        id = it.id,
                        navController = navController,
                        homeTransportRepository = homeTransportRepository
                    )
                }
            }
        }
    }

}

@Composable
fun HomeTransportItem(name:String, time:String, busnumber:String, drivername:String, id:String,
                        navController: NavHostController, homeTransportRepository: homeTransportviewmodel
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = time)
        Text(text = busnumber)
        Text(text = drivername)
        Button(onClick = {
            navController.navigate("$ROUTE_HOMETRANSPORT/$id")
        }) {
            Text(text = "Update")
        }
    }

}

@Preview
@Composable
fun View() {
    ViewHomeTransportScreen(rememberNavController())

}