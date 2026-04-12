package com.example.kartonki.ui.screen.rewards

import androidx.lifecycle.ViewModel
import com.example.kartonki.data.repository.PackRepository
import com.example.kartonki.domain.model.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class NewCardsEventViewModel @Inject constructor(
    private val packRepository: PackRepository,
) : ViewModel() {

    val pendingNewCards: StateFlow<List<Word>> = packRepository.pendingNewCards

    fun consume() = packRepository.clearPendingNewCards()
}
