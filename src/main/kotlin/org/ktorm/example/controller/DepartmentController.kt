package org.ktorm.example.controller

import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.entity.add
import org.ktorm.entity.find
import org.ktorm.entity.toList
import org.ktorm.example.model.Department
import org.ktorm.example.model.departments
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by vince on May 17, 2019.
 */
@RestController
class DepartmentController {
    @Autowired
    lateinit var database: Database

    @GetMapping("/departments/get-by-id")
    fun getDepartmentById(@RequestParam("id") id: Int): Department? {
        return database.departments.find { it.id eq id }
    }

    @GetMapping("/departments/get-all")
    fun getAllDepartments(): List<Department> {
        return database.departments.toList()
    }

    @PostMapping("/departments/create")
    fun createDepartment(
        @RequestParam("name") name: String,
        @RequestParam("location") location: String
    ): Department {
        val department = Department()
        department.name = name
        department.location = location
        database.departments.add(department)
        return department
    }
}
