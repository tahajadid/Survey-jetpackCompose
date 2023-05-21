package com.example.survey_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.survey_jetpackcompose.ui.theme.SurveyJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SurveyJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                SurveyNavHost()
            }
        }
    }
}
