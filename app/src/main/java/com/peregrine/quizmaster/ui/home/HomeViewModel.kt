package com.peregrine.quizmaster.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peregrine.quizmaster.core.UiState
import com.peregrine.quizmaster.data.model.Category
import com.peregrine.quizmaster.data.repository.FirestoreQuizRepository
import com.peregrine.quizmaster.data.repository.QuizRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val quizRepository: QuizRepository = FirestoreQuizRepository()

    private val _categoriesState = MutableStateFlow<UiState<List<Category>>>(UiState.Loading)
    val categoriesState: StateFlow<UiState<List<Category>>> = _categoriesState

    init {
        loadCategories()
    }

    fun loadCategories() {
        _categoriesState.value = UiState.Loading
        viewModelScope.launch {
            quizRepository.getCategoriesFlow().collectLatest { categories ->
                _categoriesState.value = if (categories.isNotEmpty()) {
                    UiState.Success(categories)
                } else {
                    UiState.Error("No categories found. Check your internet connection.")
                }
            }
        }
    }
}
