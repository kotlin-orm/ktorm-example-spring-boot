package me.liuwj.ktorm.example.dao

import me.liuwj.ktorm.example.model.Employee
import me.liuwj.ktorm.schema.*

/**
 * Created by vince on May 17, 2019.
 */
object Employees : Table<Employee>("t_employee") {
    val id = int("id").primaryKey().bindTo { it.id }
    val name = varchar("name").bindTo { it.name }
    val job = varchar("job").bindTo { it.job }
    val managerId = int("manager_id").bindTo { it.manager?.id }
    val hireDate = date("hire_date").bindTo { it.hireDate }
    val salary = long("salary").bindTo { it.salary }
    val departmentId = int("department_id").references(Departments) { it.department }
}