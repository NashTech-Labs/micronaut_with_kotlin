package com.learning.controller

import com.learning.entity.Employee
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

@Controller("/hello")
class HelloController {
    /**
     * The @Get annotation maps the index method to an HTTP GET request on /hello.
     *
     * By default, a Micronaut response uses application/json as Content-Type.
     * We are returning a String, not a JSON object, so we set it to text/plain
     **/

    @Get
    @Produces(MediaType.TEXT_PLAIN)
    fun index() = "Hello World! Welcome to the journey of learning MICRONAUT with KOTLIN!!"

    @Get("/message")
    @Produces(MediaType.TEXT_PLAIN)
    fun greet() = "Hi, Have a fantastic future ahead..!"

    @Get("/employee")
    fun getEmployee(): Employee {
        return Employee(101, "Rishika")
    }
}



