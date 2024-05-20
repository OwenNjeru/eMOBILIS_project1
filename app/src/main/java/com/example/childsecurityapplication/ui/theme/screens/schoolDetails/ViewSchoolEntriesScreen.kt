package com.example.childsecurityapplication.ui.theme.screens.schoolDetails

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
//import com.example.childsecurityapplication.data.SchoolEntriesViewModel
import com.example.childsecurityapplication.data.schoolEntriesviewmodel
import com.example.childsecurityapplication.data.schoolTransportviewmodel
import com.example.childsecurityapplication.model.SchoolEntries
import com.example.childsecurityapplication.model.SchoolTransport
import com.example.childsecurityapplication.navigation.ROUTE_SCHOOLENTRIES
import com.example.childsecurityapplication.navigation.ROUTE_SCHOOLTRANSPORT

@Composable
fun ViewSchoolEntriesScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var schoolEntriesRepository =
            schoolEntriesviewmodel(navController, context)
        val emptySchoolEntriesState = remember { mutableStateOf(SchoolEntries("","","","")) }
        var emptySchoolEntriesListState = remember { mutableStateListOf<SchoolEntries>() }

        var schoolEntriess = schoolEntriesRepository.viewSchoolEntriess(emptySchoolEntriesState, emptySchoolEntriesListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "School Entries Details",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(schoolEntriess){
                    SchoolEntriesItem(
                        name = it.name,
                        lastclass = it.lastclass,
                        lastteacher = it.lastteacher,
                        id = it.id,
                        navController = navController,
                        schoolEntriesRepository = schoolEntriesRepository
                    )
                }
            }
        }
    }

}

@Composable
fun SchoolEntriesItem(name:String, lastclass:String, lastteacher:String, id:String,
                        navController: NavHostController, schoolEntriesRepository: schoolEntriesviewmodel
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = lastclass)
        Text(text = lastteacher)
        Button(onClick = {
            navController.navigate("$ROUTE_SCHOOLENTRIES/$id")
        }) {
            Text(text = "Update")
        }
    }

}

@Preview
@Composable
fun SchoolEView() {
    ViewSchoolEntriesScreen(rememberNavController())

}