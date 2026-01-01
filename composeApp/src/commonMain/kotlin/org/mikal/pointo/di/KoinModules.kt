package org.mikal.pointo.di

import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module
import org.mikal.pointo.data.PostRepository
import org.mikal.pointo.domain.usecase.GetPostsUseCase
import org.mikal.pointo.network.api.ApiService
import org.mikal.pointo.network.api.ApiServiceImpl
import org.mikal.pointo.network.api.HttpClientFactory
import org.mikal.pointo.ui.PostHomeViewModel

val networkModule = module {
    single { HttpClientFactory.create() }
    singleOf(::ApiServiceImpl) bind ApiService::class
}

val repositoryModule = module {
    singleOf(::PostRepository)
}

val useCaseModule = module {
    singleOf(::GetPostsUseCase)
}

val presentationModule = module {
    viewModelOf(::PostHomeViewModel)
}

val sharedModule = module {
    includes(
        networkModule,
        repositoryModule,
        useCaseModule,
        presentationModule
    )
}
