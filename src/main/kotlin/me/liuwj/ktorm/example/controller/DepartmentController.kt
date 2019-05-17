package me.liuwj.ktorm.example.controller

import me.liuwj.ktorm.entity.add
import me.liuwj.ktorm.entity.findAll
import me.liuwj.ktorm.entity.findById
import me.liuwj.ktorm.example.dao.Departments
import me.liuwj.ktorm.example.model.Department
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

/**
 * Created by vince on May 17, 2019.
 */
@RestController
class DepartmentController {

    @GetMapping("/departments/get-by-id")
    fun getDepartmentById(@RequestParam("id") id: Int): Department? {
        return Departments.findById(id)
    }

    @GetMapping("/departments/get-all")
    fun getAllDepartments(): List<Department> {
        return Departments.findAll()
    }

    @PostMapping("/departments/create")
    fun createDepartment(
        @RequestParam("name") name: String,
        @RequestParam("location") location: String
    ): Department {
        val department = Department()
        department.name = name
        department.location = location
        Departments.add(department)
        return department
    }
}