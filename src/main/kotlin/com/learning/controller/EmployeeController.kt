package com.learning.controller

import com.learning.entity.Employee
import com.learning.repository.EmployeeRepository
import io.micronaut.core.annotation.NonNull
import io.micronaut.http.annotation.*
import java.util.*

/**
 * Controller for handling operations related to employees.
 * This controller handles CRUD operations for employee data.
 *
 * @param employeeRepository The repository for accessing and managing employee data.
 */
@Controller("/employee")
class EmployeeController(private val employeeRepository: EmployeeRepository) {

    /**
     * Retrieve an employee by their ID.
     *
     * @param id The ID of the employee to retrieve.
     * @return An optional containing the employee if found, otherwise empty.
     */
    @Get("/{id}")
    fun getEmployee(id: Long): @NonNull Optional<Employee>? {
        return employeeRepository.findById(id)
    }

    /**
     * Retrieve all employee data.
     *
     * @return A list of all employees.
     */
    @Get("/all-employee-data")
    fun getAllEmployees(): List<Employee> {
        return employeeRepository.findAll().toList()
    }

    /**
     * Create a new employee.
     *
     * @param employee The employee data to create.
     * @return The created employee.
     */
    @Post("/create-employee")
    fun createEmployee(@Body employee: Employee): Employee {
        return employeeRepository.save(employee)
    }

    /**
     * Update an existing employee's name by their ID.
     *
     * @param id The ID of the employee to update.
     * @param updatedEmployee The updated employee data.
     * @return A message indicating the result of the update operation.
     */
    @Put("/{id}")
    fun updateEmployee(id: Long, @Body updatedEmployee: Employee): Any {
        val optionalExistingEmployee = employeeRepository.findById(id)
        if (optionalExistingEmployee.isPresent) {
            val existingEmployee = optionalExistingEmployee.get()
            // Update the existing employee's name
            existingEmployee.name = updatedEmployee.name
            val updated = employeeRepository.update(existingEmployee)
            return if (updated != null) {
                "Employee with ID $id updated successfully"
            } else {
                "Failed to update employee with ID $id"
            }
        }
        return "Employee with ID $id not found"
    }

    /**
     * Delete an employee by their ID.
     *
     * @param id The ID of the employee to delete.
     * @return A message indicating the result of the delete operation.
     */
    @Delete("/{id}")
    fun deleteEmployee(id: Long): String {
        val optionalExistingEmployee = employeeRepository.findById(id)
        if (optionalExistingEmployee.isPresent) {
            val existingEmployee = optionalExistingEmployee.get()
            employeeRepository.delete(existingEmployee)
            return "Employee with ID $id has been successfully deleted."
        }
        return "Employee with ID $id was not found."
    }
}
