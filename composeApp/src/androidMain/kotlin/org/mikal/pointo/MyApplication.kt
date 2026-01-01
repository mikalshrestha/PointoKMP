package org.mikal.pointo

import android.app.Application

/**
 * Created by Mikal Shrestha on 01/01/2026.
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
//        initKoin {
//            androidLogger(Level.DEBUG)
//            androidContext(this@CinemaxApplication)
//        }
    }
}
