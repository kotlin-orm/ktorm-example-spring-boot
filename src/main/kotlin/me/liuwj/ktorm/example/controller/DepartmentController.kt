package me.liuwj.ktorm.example.controller

import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.dsl.eq
import me.liuwj.ktorm.entity.*
import me.liuwj.ktorm.example.dao.Departments
import me.liuwj.ktorm.example.model.Department
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
        return database.sequenceOf(Departments).find { it.id eq id }
    }

    @GetMapping("/departments/get-all")
    fun getAllDepartments(): List<Department> {
        return database.sequenceOf(Departments).toList()
    }

    @PostMapping("/departments/create")
    fun createDepartment(
        @RequestParam("name") name: String,
        @RequestParam("location") location: String
    ): Department {
        val department = Department()
        department.name = name
        department.location = location
        database.sequenceOf(Departments).add(department)
        return department
    }
}