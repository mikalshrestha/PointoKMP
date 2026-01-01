package org.mikal.pointo.di

import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    if (GlobalContext.getOrNull() == null) {
        startKoin {
            config?.invoke(this)
            modules(sharedModule)
        }
    }
}