package org.mikal.pointo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform