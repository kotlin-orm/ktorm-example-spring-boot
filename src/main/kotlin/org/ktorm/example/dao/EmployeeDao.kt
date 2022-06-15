package org.ktorm.example.dao

import org.ktorm.dsl.eq
import org.ktorm.entity.*
import org.ktorm.example.dto.PageDTO
import org.ktorm.example.model.Employee
import org.ktorm.example.model.Employees
import org.ktorm.example.model.employees
import org.springframework.stereotype.Component

/**
 * Created by vince on Jun 15, 2022.
 */
@Component
class EmployeeDao : BaseDao<Employee, Employees>(Employees) {

    fun getEmployeeById(id: Int): Employee? {
        return database.employees.find { it.id eq id }
    }

    fun getEmployees(departmentId: Int, startIndex: Int, pageSize: Int): PageDTO<Employee> {
        val employees = database.employees
            .filter { it.departmentId eq departmentId }
            .drop(startIndex)
            .take(pageSize)

        return PageDTO(employees.toList(), employees.totalRecords, startIndex, pageSize)
    }

    fun getAverageSalaries(): Map<Int?, Double?> {
        return database.employees.groupingBy { it.departmentId }.eachAverageBy { it.salary }
    }
}