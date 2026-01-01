package org.mikal.pointo.data

import org.mikal.pointo.network.api.ApiService

class PostRepository(private val api: ApiService) {
    suspend fun getPosts() = api.getPosts()
}
