package org.mikal.pointo

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.mikal.pointo.di.initKoin
import org.koin.core.logger.Level

/**
 * Created by Mikal Shrestha on 01/01/2026.
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyApplication)
        }
    }
}
