package com.example.survey_jetpackcompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.survey_jetpackcompose.Destinations.SURVEY_ROUTE
import com.example.survey_jetpackcompose.Destinations.WELCOME_ROUTE
import com.example.survey_jetpackcompose.ui.screens.survey.SurveyRoute
import com.example.survey_jetpackcompose.ui.screens.welcome.WelcomeRoute

object Destinations {
    const val WELCOME_ROUTE = "welcome"
    const val SURVEY_ROUTE = "survey"
}

@Composable
fun SurveyNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = WELCOME_ROUTE,
    ) {
        composable(WELCOME_ROUTE) {
            WelcomeRoute(
                onNavigateToSignIn = {
                    navController.navigate(SURVEY_ROUTE)
                },
                onNavigateToSignUp = {
                    navController.navigate("signup/$it")
                },
                onSignInAsGuest = {
                    navController.navigate(SURVEY_ROUTE)
                },
            )
        }

        composable(SURVEY_ROUTE) {
            SurveyRoute(
                onSurveyComplete = {
                    navController.navigate(WELCOME_ROUTE)
                },
                onNavUp = navController::navigateUp,
            )
        }
    }
}
