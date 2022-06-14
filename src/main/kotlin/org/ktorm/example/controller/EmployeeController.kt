package org.ktorm.example.controller

import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.entity.*
import org.ktorm.example.model.Employee
import org.ktorm.example.model.employees
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

/**
 * Created by vince on May 17, 2019.
 */
@RestController
class EmployeeController {
    @Autowired
    lateinit var database: Database

    @GetMapping("/employees/get-by-id")
    fun getEmployeeById(@RequestParam("id") id: Int): Employee? {
        return database.employees.find { it.id eq id }
    }

    data class Page<T>(
        val offset: Int,
        val limit: Int,
        val totalRecords: Int,
        val pageSize: Int = limit,
        val totalPages: Int = if (totalRecords % pageSize == 0) totalRecords / pageSize else totalRecords / pageSize + 1,
        val currentList: List<T>
    )

    @GetMapping("/employees/get-list")
    fun getEmployees(
        @RequestParam("departmentId") departmentId: Int,
        @RequestParam("offset") offset: Int,
        @RequestParam("limit") limit: Int
    ): Page<Employee> {
        val employees = database.employees
            .filter { it.departmentId eq departmentId }
            .drop(offset)
            .take(limit)

        return Page(offset, limit, employees.totalRecords, currentList = employees.toList())
    }

    @GetMapping("/employees/average-salaries")
    fun getAverageSalaries(): Map<Int?, Double?> {
        return database.employees
            .groupingBy { it.departmentId }
            .eachAverageBy { it.salary }
    }

    @GetMapping("/test")
    fun test(e: Employee): Employee {
        return e
    }
}
