package org.mikal.pointo.network.api

import co.touchlab.kermit.Logger
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.mikal.pointo.network.util.Constants

object HttpClientFactory {
    fun create(): HttpClient = HttpClient {
        expectSuccess = false

        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    explicitNulls = false
                    isLenient = true
                }
            )
        }

        install(Logging) {
            logger = object : io.ktor.client.plugins.logging.Logger {
                override fun log(message: String) {
                    Logger.d { message }
                }
            }
            level = LogLevel.BODY
        }

        install(HttpTimeout) {
            connectTimeoutMillis = 30_000
            requestTimeoutMillis = 60_000
        }

        HttpResponseValidator {
            handleResponseExceptionWithRequest { exception, _ ->
                if (exception is ResponseException) {
                    Logger.e { "HTTP Error: ${exception.response.status}" }
                }
            }
        }

        defaultRequest {
            url(Constants.API_URL)
            contentType(ContentType.Application.Json)
        }
    }
}
