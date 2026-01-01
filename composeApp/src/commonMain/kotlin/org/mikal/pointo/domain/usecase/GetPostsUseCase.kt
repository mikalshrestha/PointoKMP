package org.mikal.pointo.domain.usecase

import org.mikal.pointo.data.PostRepository

class GetPostsUseCase(private val repository: PostRepository) {
    suspend operator fun invoke() = repository.getPosts()
}
