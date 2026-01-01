package org.mikal.pointo.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PostListScreen(viewModel: PostHomeViewModel, modifier: Modifier = Modifier) {
    val state by viewModel.uiState.collectAsState()

    if (state.isLoading) {
        Column(modifier = modifier.padding(16.dp)) {
            CircularProgressIndicator()
        }
        return
    }

    LazyColumn(modifier = modifier.fillMaxSize().padding(8.dp)) {
        items(state.posts) { post ->
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = post.title, style = MaterialTheme.typography.titleMedium)
                Text(text = post.content, style = MaterialTheme.typography.bodyMedium, modifier = Modifier.padding(top = 4.dp))
            }
        }
    }
}
