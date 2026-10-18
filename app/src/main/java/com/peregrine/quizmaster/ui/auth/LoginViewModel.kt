package com.peregrine.quizmaster.ui.auth

import android.content.Context
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.firebase.auth.auth
import com.google.firebase.Firebase
import com.peregrine.quizmaster.core.UiState
import com.peregrine.quizmaster.data.model.User
import com.peregrine.quizmaster.data.repository.AuthRepository
import com.peregrine.quizmaster.data.repository.FirebaseAuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val authRepository: AuthRepository = FirebaseAuthRepository()

    private val _loginState = MutableStateFlow<UiState<Unit>>(UiState.Idle)
    val loginState: StateFlow<UiState<Unit>> = _loginState

    fun isAlreadyLoggedIn(): Boolean = authRepository.isLoggedIn()

    fun signInWithGoogle(context: Context, onSuccess: () -> Unit) {
        _loginState.value = UiState.Loading
        viewModelScope.launch {
            try {
                val credentialManager = CredentialManager.create(context)

                val googleIdOption = GetGoogleIdOption.Builder()
                    .setFilterByAuthorizedAccounts(false)
                    .setServerClientId(WEB_CLIENT_ID)
                    .build()

                val request = GetCredentialRequest.Builder()
                    .addCredentialOption(googleIdOption)
                    .build()

                val result = credentialManager.getCredential(context, request)
                val credential = result.credential

                if (credential is CustomCredential &&
                    credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
                ) {
                    val googleIdToken = GoogleIdTokenCredential.createFrom(credential.data)
                    val signInResult = authRepository.signInWithGoogle(googleIdToken.idToken)

                    signInResult.fold(
                        onSuccess = { firebaseUser ->
                            // Save user to Firestore (merge — don't overwrite existing stats)
                            val existing = authRepository.getUserFromFirestore(firebaseUser.uid)
                            if (existing == null) {
                                authRepository.saveUserToFirestore(
                                    User(
                                        uid = firebaseUser.uid,
                                        name = firebaseUser.displayName ?: "",
                                        email = firebaseUser.email ?: "",
                                        photoUrl = firebaseUser.photoUrl?.toString() ?: ""
                                    )
                                )
                            }
                            _loginState.value = UiState.Success(Unit)
                            onSuccess()
                        },
                        onFailure = { e ->
                            _loginState.value = UiState.Error(e.message ?: "Sign-in failed")
                        }
                    )
                } else {
                    _loginState.value = UiState.Error("Unexpected credential type")
                }
            } catch (e: Exception) {
                _loginState.value = UiState.Error(e.message ?: "Sign-in failed")
            }
        }
    }

    fun continueAsGuest(onSuccess: () -> Unit) {
        // Guest: no Firebase auth, just go to Home
        _loginState.value = UiState.Idle
        onSuccess()
    }

    fun resetState() {
        _loginState.value = UiState.Idle
    }

    companion object {
        // Your Firebase Web Client ID — get from Firebase Console → Authentication → Google → Web client ID
        // TODO: Replace with your actual Web Client ID from Firebase Console
        const val WEB_CLIENT_ID =
            "1067229440289-pt8pd7sb7t3jsj3gt8frqdoo6de6qqmf.apps.googleusercontent.com"
    }
}
