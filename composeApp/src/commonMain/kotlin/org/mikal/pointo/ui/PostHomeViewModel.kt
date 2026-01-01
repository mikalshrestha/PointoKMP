package org.mikal.pointo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.mikal.pointo.domain.usecase.GetPostsUseCase
import org.mikal.pointo.network.api.PostDto

data class PostHomeUiState(
    val isLoading: Boolean = false,
    val posts: List<PostDto> = emptyList(),
    val error: String? = null
)

class PostHomeViewModel(private val getPostsUseCase: GetPostsUseCase) : ViewModel() {
    private val _uiState = MutableStateFlow(PostHomeUiState())
    val uiState: StateFlow<PostHomeUiState> = _uiState.asStateFlow()

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            try {
                val posts = getPostsUseCase()
                _uiState.value = _uiState.value.copy(isLoading = false, posts = posts)
            } catch (t: Throwable) {
                _uiState.value = _uiState.value.copy(isLoading = false, error = t.message)
            }
        }
    }
}
