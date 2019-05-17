package me.liuwj.ktorm.example.model

import me.liuwj.ktorm.entity.Entity
import java.time.LocalDate

/**
 * Created by vince on May 17, 2019.
 */
interface Employee : Entity<Employee> {
    companion object : Entity.Factory<Employee>()
    var id: Int
    var name: String
    var job: String
    var manager: Employee?
    var hireDate: LocalDate
    var salary: Long
    var department: Department
}