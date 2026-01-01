package org.mikal.pointo

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.koin.compose.viewmodel.koinViewModel
import org.mikal.pointo.di.initKoin
import org.mikal.pointo.ui.PostHomeViewModel
import org.mikal.pointo.ui.PostListScreen

@Composable
fun App() {
    // ensure Koin is started (safe no-op if already initialized by Application)
    //make sure initKoin cmust be called from entry point of each platform:::
    //call from MyAPllication, MyViewController etc.
    // called from entry point of each platfrom instead call here
    //initKoin()
    MaterialTheme {
        val vm: PostHomeViewModel = koinViewModel()
        PostListScreen(viewModel = vm, modifier = Modifier.fillMaxSize())
    }
}