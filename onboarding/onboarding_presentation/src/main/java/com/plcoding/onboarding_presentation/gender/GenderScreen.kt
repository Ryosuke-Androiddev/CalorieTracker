package com.plcoding.onboarding_presentation.gender

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.plcoding.core.domain.model.Gender
import com.plcoding.core.navigation.Route
import com.plcoding.core.util.UiEvent
import com.plcoding.core_ui.LocalSpacing
import com.plcoding.onboarding_presentation.R
import com.plcoding.onboarding_presentation.components.ActionButton
import com.plcoding.onboarding_presentation.components.SelectableButton
import com.plcoding.onboarding_presentation.gender.viewmodel.GenderViewModel
import kotlinx.coroutines.flow.collect

@Composable
fun GenderScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: GenderViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current

    LaunchedEffect(key1 = true) {
        viewModel.genderPickOneTimeEvent.collect { event ->
            when (event) {
                is UiEvent.Navigate -> {
                    onNavigate(event)
                }
                else -> Unit
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.whats_your_gender),
                style = MaterialTheme.typography.h3
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            Row {
               SelectableButton(
                   text = stringResource(id = R.string.male),
                   selectedTextColor = Color.White,
                   color = MaterialTheme.colors.primaryVariant,
                   isSelected = viewModel.selectedGender is Gender.Male,
                   textStyle = MaterialTheme.typography.button.copy(
                       fontWeight = FontWeight.Normal
                   ),
                   onClick = {
                       viewModel.onGenderClick(Gender.Male)
                   }
               )
               Spacer(modifier = Modifier.width(spacing.spaceMedium))
                SelectableButton(
                    text = stringResource(id = R.string.female),
                    selectedTextColor = Color.White,
                    color = MaterialTheme.colors.primaryVariant,
                    isSelected = viewModel.selectedGender is Gender.Female,
                    textStyle = MaterialTheme.typography.button.copy(
                        fontWeight = FontWeight.Normal
                    ),
                    onClick = {
                        viewModel.onGenderClick(Gender.Female)
                    }
                )
            }
        }
        ActionButton(
            modifier = Modifier.align(Alignment.BottomEnd),
            text = stringResource(id = R.string.next),
            onClick = {
                onNavigate(UiEvent.Navigate(route = Route.AGE))
            }
        )
    }
}