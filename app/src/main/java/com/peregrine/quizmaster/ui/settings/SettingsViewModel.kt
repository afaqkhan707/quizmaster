package com.peregrine.quizmaster.ui.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.peregrine.quizmaster.core.UiState
import com.peregrine.quizmaster.data.model.User
import com.peregrine.quizmaster.data.repository.AuthRepository
import com.peregrine.quizmaster.data.repository.FirebaseAuthRepository
import com.peregrine.quizmaster.data.repository.FirestoreQuizRepository
import com.peregrine.quizmaster.data.repository.QuizRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SettingsViewModel : ViewModel() {

    private val authRepository: AuthRepository = FirebaseAuthRepository()
    private val quizRepository: QuizRepository = FirestoreQuizRepository()

    private val _userState = MutableStateFlow<UiState<User>>(UiState.Loading)
    val userState: StateFlow<UiState<User>> = _userState

    val isGuest: Boolean get() = authRepository.getCurrentUser() == null

    init {
        loadUser()
    }

    fun loadUser() {
        val firebaseUser = authRepository.getCurrentUser()
        if (firebaseUser == null) {
            // Guest user
            _userState.value = UiState.Success(
                User(name = "Guest User", email = "Playing without an account")
            )
            return
        }

        _userState.value = UiState.Loading
        viewModelScope.launch {
            val user = authRepository.getUserFromFirestore(firebaseUser.uid)
            _userState.value = if (user != null) {
                UiState.Success(user)
            } else {
                // Fallback to Firebase Auth data
                UiState.Success(
                    User(
                        uid = firebaseUser.uid,
                        name = firebaseUser.displayName ?: "",
                        email = firebaseUser.email ?: "",
                        photoUrl = firebaseUser.photoUrl?.toString() ?: ""
                    )
                )
            }
        }
    }

    fun seedSampleData(onResult: (Boolean, String?) -> Unit) {
        viewModelScope.launch {
            val result = quizRepository.seedSampleData()
            result.fold(
                onSuccess = { onResult(true, "Successfully uploaded 4 categories & 40 questions!") },
                onFailure = { e -> onResult(false, e.message ?: "Upload failed") }
            )
        }
    }

    fun signOut(onSignedOut: () -> Unit) {
        authRepository.signOut()
        onSignedOut()
    }
}
