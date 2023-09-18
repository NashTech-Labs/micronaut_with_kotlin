package com.learning.repository

import com.learning.entity.Employee
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository


@JdbcRepository(dialect = Dialect.MYSQL)
@Repository
interface EmployeeRepository : CrudRepository<Employee, Long>  {
    // Define any custom query methods if needed.
}