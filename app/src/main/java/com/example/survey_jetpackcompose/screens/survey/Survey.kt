package com.example.survey_jetpackcompose.screens.survey

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.survey_jetpackcompose.R
import com.example.survey_jetpackcompose.screens.survey.singleChoice.SingleChoiceQuestion
import com.example.survey_jetpackcompose.screens.survey.singleChoice.Superhero

@Composable
fun FreeTimeQuestion(
    selectedAnswers: List<Int>,
    onOptionSelected: (selected: Boolean, answer: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    /*
    MultipleChoiceQuestion(
        titleResourceId = R.string.in_my_free_time,
        directionsResourceId = R.string.in_my_free_time,
        possibleAnswers = listOf(
            R.string.read,
            R.string.work_out,
            R.string.draw,
            R.string.play_games,
            R.string.dance,
            R.string.watch_movies,
        ),
        selectedAnswers = selectedAnswers,
        onOptionSelected = onOptionSelected,
        modifier = modifier,
    )

     */
}

@Composable
fun SuperheroQuestion(
    selectedAnswer: Superhero?,
    onOptionSelected: (Superhero) -> Unit,
    modifier: Modifier = Modifier
) {
    SingleChoiceQuestion(
        titleResourceId = R.string.pick_superhero,
        directionsResourceId = R.string.select_one,
        possibleAnswers = listOf(
            Superhero(R.string.spark, R.drawable.my_survey_logo_login),
            Superhero(R.string.lenz, R.drawable.my_survey_logo_login),
            Superhero(R.string.bugchaos, R.drawable.my_survey_logo_login),
            Superhero(R.string.frag, R.drawable.my_survey_logo_login)
        ),
        selectedAnswer = selectedAnswer,
        onOptionSelected = onOptionSelected,
        modifier = modifier
    )
}
