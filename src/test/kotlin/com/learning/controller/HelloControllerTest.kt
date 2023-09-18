package com.learning.controller

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

/**
 * Annotate the class with @MicronautTest so the Micronaut framework will initialize the application context
 * and the embedded server.
 *
 * Inject the HttpClient bean and point it to the embedded server.
 * Creating HTTP Requests is easy thanks to the Micronaut framework fluid API.
 **/

@MicronautTest
class HelloControllerTest(@Client("/") val client: HttpClient) {

    @Inject
   // EmbeddedServer embeddedServer;

    @Test
    fun testHello() {
        val request: HttpRequest<Any> = HttpRequest.GET("/hello")
        val body = client.toBlocking().retrieve(request)
        assertNotNull(body)
        assertEquals("Hello World! Welcome to the journey of learning MICRONAUT with KOTLIN!!", body)
    }
}