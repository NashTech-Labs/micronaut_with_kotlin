package com.learning.entity

import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.serde.annotation.Serdeable
import jakarta.inject.Singleton

/**
 * The `Employee` data class represents information about an employee in a hypothetical system.
 * It is designed to hold basic details of an employee such as their ID and name.
 *
 * This class is annotated with several custom annotations:
 *
 * - `@Singleton`: Indicates that instances of this class are intended to be singletons, meaning
 *   there should be only one instance of an `Employee` at a time.
 *
 * - `@Serdeable`: Suggests that this class is serializable and can be converted to and from
 *   different data formats, likely for data storage or communication purposes.
 *
 * - `@MappedEntity`: Implies that this class is related to some form of data mapping or data storage,
 *   and it may be used to map to a database table or other data structures.
 *
 * @property id The unique identifier for the employee. It is annotated with `@Id`, indicating that
 *           it represents the primary key for database operations. By default, it is set to 0.
 *
 * @property name The name of the employee. This is a mutable property, allowing the name to be
 *            modified after the `Employee` object is created.
 *
 * @constructor Creates an `Employee` object with optional initial values for `id` and `name`.
 *
 * @param id The unique identifier for the employee. Defaults to 0 if not provided.
 * @param name The name of the employee. Defaults to an empty string if not provided.
 */

@Singleton
@Serdeable
@MappedEntity
data class Employee(
    @field: Id
    val id: Long = 0,
    var name: String = "",
)



