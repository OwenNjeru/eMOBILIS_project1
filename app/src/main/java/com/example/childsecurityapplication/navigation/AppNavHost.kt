package com.example.childsecurityapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.childsecurityapplication.ui.theme.screens.home.HomeScreen
import com.example.childsecurityapplication.ui.theme.screens.homeTransport.HomeTransportScreen
import com.example.childsecurityapplication.ui.theme.screens.homeTransport.ViewHomeTransportScreen
import com.example.childsecurityapplication.ui.theme.screens.login.LoginScreen
import com.example.childsecurityapplication.ui.theme.screens.register.RegisterScreen
import com.example.childsecurityapplication.ui.theme.screens.schoolDetails.SchoolEntriesScreen
import com.example.childsecurityapplication.ui.theme.screens.schoolDetails.ViewSchoolEntriesScreen
import com.example.childsecurityapplication.ui.theme.screens.schoolTransport.SchoolTransportScreen
import com.example.childsecurityapplication.ui.theme.screens.schoolTransport.ViewSchoolTransportScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController(),
               startDestination: String= ROUTE_LOGIN) {
    NavHost(navController = navController, startDestination = startDestination, modifier = modifier) {

        composable(ROUTE_LOGIN) {
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER) {
            RegisterScreen(navController)
        }

        composable(ROUTE_HOME) {
            HomeScreen(navController)
        }
        composable(ROUTE_HOMETRANSPORT) {
            HomeTransportScreen(navController)
        }
        composable(ROUTE_VIEWHOMETRANSPORT) {
            ViewHomeTransportScreen(navController)
        }
        composable(ROUTE_SCHOOLENTRIES) {
            SchoolEntriesScreen(navController)
        }
        composable(ROUTE_VIEWSCHOOLENTRIES) {
            ViewSchoolEntriesScreen(navController)
        }
        composable(ROUTE_SCHOOLTRANSPORT) {
            SchoolTransportScreen(navController)
        }
        composable(ROUTE_VIEWSCHOOLTRANSPORT) {
            ViewSchoolTransportScreen(navController)
        }

    }
}
