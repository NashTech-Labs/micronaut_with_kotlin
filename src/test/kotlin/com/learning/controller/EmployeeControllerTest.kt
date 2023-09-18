package com.learning.controller

import com.learning.entity.Employee
import com.learning.repository.EmployeeRepository
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.*

@MicronautTest
class EmployeeControllerTest(
    private val employeeRepository: EmployeeRepository,

    @Client("/") private val client: HttpClient
) {
    @BeforeEach
    fun setup() {

        val employeeRepository = Mockito.mock(EmployeeRepository::class.java)

        // Correct: Using a valid method call on the mock
        Mockito.`when`(employeeRepository.findById(1L)).thenReturn(Optional.of(Employee(1L, "Sam")))
        // Mock the behavior of the EmployeeRepository
        Mockito.`when`(employeeRepository.findById(1L)).thenReturn(Optional.of(Employee(1L, "Sam")))
        Mockito.`when`(employeeRepository.findAll()).thenReturn(listOf(Employee(1L, "Sam"), Employee(2L, "Dean")))
        Mockito.`when`(employeeRepository.save(Employee(1L, "Sam"))).thenReturn(Employee(1L, "Sam"))
        Mockito.`when`(employeeRepository.update(Employee(1L, "Sam"))).thenReturn(Employee(1L, "Sam"))
    }

    @Test
    fun testGetEmployeeById() {
        val response = client.toBlocking().exchange("/employee/1", Employee::class.java)
        assertEquals(HttpStatus.OK, response.status)
        assertEquals(Employee(1L, "Updated Sam"), response.body())
    }


    @Test
    fun testCreateEmployee() {
        val employeeToCreate = Employee(8L, "Sam")

        val request = HttpRequest.POST("/employee/create-employee", employeeToCreate)
            .contentType(MediaType.APPLICATION_JSON_TYPE) // Set the content type if needed

        val response = client.toBlocking().exchange(request, Employee::class.java)

        assertEquals(HttpStatus.OK, response.status)
        assertEquals(employeeToCreate, response.body())
    }
    @Test
    fun testUpdateEmployee() {
        val updatedEmployee = Employee(1L, "Updated Sam")

        val request = HttpRequest.PUT("/employee/1", updatedEmployee)
            .contentType(MediaType.APPLICATION_JSON_TYPE)

        val response = client.toBlocking().exchange(request, String::class.java)

        assertEquals(HttpStatus.OK, response.status)
        assertEquals("Employee with ID 1 updated successfully", response.body())
    }

}




