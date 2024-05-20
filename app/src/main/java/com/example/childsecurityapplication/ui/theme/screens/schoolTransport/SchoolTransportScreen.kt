package com.example.childsecurityapplication.ui.theme.screens.schoolTransport

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.childsecurityapplication.data.schoolTransportviewmodel
import com.example.childsecurityapplication.navigation.ROUTE_VIEWSCHOOLTRANSPORT

@Composable
fun SchoolTransportScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        Text(
            text = "Add school entries Details",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Red,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )

        var name by remember { mutableStateOf(TextFieldValue("")) }
        var time by remember { mutableStateOf(TextFieldValue("")) }
        var busnumber by remember { mutableStateOf(TextFieldValue("")) }
        var drivername by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Enter child's name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = time,
            onValueChange = { time = it },
            label = { Text(text = "Enter time of Departure*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = busnumber,
            onValueChange = { busnumber = it },
            label = { Text(text = "Enter the bus number *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = drivername,
            onValueChange = { drivername = it },
            label = { Text(text = "Enter the driver's name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Button(onClick = {
            //-----------WRITE THE SAVE LOGIC HERE---------------//
            var schoolTransportRepository = schoolTransportviewmodel(navController, context)
            schoolTransportRepository.saveSchoolTransport(
                name.text.trim(), time.text.trim(),
                busnumber.text, drivername.text.trim()
            )
            navController.navigate(ROUTE_VIEWSCHOOLTRANSPORT)


        }) {
            Text(text = "Save")
        }
        Spacer(modifier = Modifier.height(20.dp))

    }
}
@Preview
@Composable
fun SchoolTprev () {
    SchoolTransportScreen(rememberNavController())

}


