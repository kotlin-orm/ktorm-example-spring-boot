package org.ktorm.example.controller

import org.ktorm.example.dao.EmployeeDao
import org.ktorm.example.dto.PageDTO
import org.ktorm.example.model.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by vince on May 17, 2019.
 */
@RestController
class EmployeeController {
    @Autowired
    lateinit var employeeDao: EmployeeDao

    @GetMapping("/employees/get-by-id")
    fun getEmployeeById(@RequestParam("id") id: Int): Employee? {
        return employeeDao.getEmployeeById(id)
    }

    @GetMapping("/employees/get-list")
    fun getEmployees(
        @RequestParam("departmentId") departmentId: Int,
        @RequestParam("offset") offset: Int,
        @RequestParam("limit") limit: Int
    ): PageDTO<Employee> {
        return employeeDao.getEmployees(departmentId, offset, limit)
    }

    @GetMapping("/employees/average-salaries")
    fun getAverageSalaries(): Map<Int?, Double?> {
        return employeeDao.getAverageSalaries()
    }
}
