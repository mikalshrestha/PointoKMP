package org.mikal.pointo.network.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

interface ApiService {
    suspend fun getPosts(): List<PostDto>
}

@Serializable
data class PostDto(
    val userId: Int,
    val id: Int,
    val title: String,
    @SerialName("body") val content: String
)

class ApiServiceImpl(private val client: HttpClient) : ApiService {
    override suspend fun getPosts(): List<PostDto> =
        client.get("posts").body()
}
