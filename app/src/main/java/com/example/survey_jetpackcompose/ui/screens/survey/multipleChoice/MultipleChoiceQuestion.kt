package com.example.survey_jetpackcompose.ui.screens.survey.multipleChoice

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.survey_jetpackcompose.R
import com.example.survey_jetpackcompose.ui.screens.QuestionWrapper
import com.example.survey_jetpackcompose.ui.theme.defaultColor
import com.example.survey_jetpackcompose.ui.theme.primaryColor
import com.example.survey_jetpackcompose.ui.theme.tertiaryColor

@Composable
fun MultipleChoiceQuestion(
    @StringRes titleResourceId: Int,
    @StringRes directionsResourceId: Int,
    possibleAnswers: List<Int>,
    selectedAnswers: List<Int>,
    onOptionSelected: (selected: Boolean, answer: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    QuestionWrapper(
        modifier = modifier,
        titleResourceId = titleResourceId,
        directionsResourceId = directionsResourceId
    ) {
        possibleAnswers.forEach {
            val selected = selectedAnswers.contains(it)
            CheckboxRow(
                modifier = Modifier.padding(vertical = 8.dp),
                text = stringResource(id = it),
                selected = selected,
                onOptionSelected = { onOptionSelected(!selected, it) }
            )
        }
    }
}

@Composable
fun CheckboxRow(
    text: String,
    selected: Boolean,
    onOptionSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        color = if (selected) {
            primaryColor
        } else {
            tertiaryColor
        },
        border = BorderStroke(
            width = 1.dp,
            color = if (selected) {
                defaultColor
            } else {
                tertiaryColor
            }
        ),
        modifier = modifier
            .clip(MaterialTheme.shapes.small)
            .clickable(onClick = onOptionSelected)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text, Modifier.weight(1f), style = MaterialTheme.typography.bodyLarge)
            Box(Modifier.padding(8.dp)) {
                Checkbox(
                    selected,
                    onCheckedChange = null,
                    Modifier.padding(8.dp),
                    colors = CheckboxDefaults.colors(defaultColor, defaultColor)
                )
            }
        }
    }
}

@Preview
@Composable
fun MultipleChoiceQuestionPreview() {
    val possibleAnswers = listOf(R.string.read, R.string.work_out, R.string.draw)
    val selectedAnswers = remember { mutableStateListOf(R.string.work_out) }
    MultipleChoiceQuestion(
        titleResourceId = R.string.in_my_free_time,
        directionsResourceId = R.string.choice1,
        possibleAnswers = possibleAnswers,
        selectedAnswers = selectedAnswers,
        onOptionSelected = { _, _ -> }
    )
}
