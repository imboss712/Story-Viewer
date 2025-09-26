package com.materna.storyviewer.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor() : ViewModel() {
    private val _showSplashScreen = MutableStateFlow(true)
    val showSplashScreen: StateFlow<Boolean> = _showSplashScreen.asStateFlow()

    init {
        hideSplashScreenAfterDelay()
    }

    private fun hideSplashScreenAfterDelay() = viewModelScope.launch {
        delay(1_500L)
        _showSplashScreen.value = false
    }
}
