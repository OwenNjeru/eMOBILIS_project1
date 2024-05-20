package com.example.childsecurityapplication.ui.theme.screens.schoolDetails

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
import com.example.childsecurityapplication.data.schoolEntriesviewmodel
//import com.example.childsecurityapplication.data.SchoolEntriesViewModel
import com.example.childsecurityapplication.data.schoolTransportviewmodel
import com.example.childsecurityapplication.navigation.ROUTE_VIEWSCHOOLENTRIES
import com.example.childsecurityapplication.navigation.ROUTE_VIEWSCHOOLTRANSPORT

@Composable
fun SchoolEntriesScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        val context = LocalContext.current
        Text(
            text = "Add Details",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Red,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )

        var name by remember { mutableStateOf(TextFieldValue("")) }
        var lastclass by remember { mutableStateOf(TextFieldValue("")) }
        var lastteacher by remember { mutableStateOf(TextFieldValue("")) }


        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Enter child's name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = lastclass,
            onValueChange = { lastclass = it },
            label = { Text(text = "Enter last class attended*") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = lastteacher,
            onValueChange = { lastteacher = it },
            label = { Text(text = "Enter the last teacher's name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))


        Button(onClick = {
            //-----------WRITE THE SAVE LOGIC HERE---------------//
            val schoolEntriesRepository =
                schoolEntriesviewmodel(navController, context)
            schoolEntriesRepository.saveSchoolEntries(
                name.text.trim(), lastclass.text.trim(),
                lastteacher.text,
            )
            navController.navigate(ROUTE_VIEWSCHOOLENTRIES)


        }) {
            Text(text = "Save")
        }
        Spacer(modifier = Modifier.height(20.dp))

    }
}
@Preview
@Composable
fun Schoolprev() {
    SchoolEntriesScreen(rememberNavController())

}