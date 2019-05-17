package me.liuwj.ktorm.example.dao

import me.liuwj.ktorm.example.model.Employee
import me.liuwj.ktorm.schema.*

/**
 * Created by vince on May 17, 2019.
 */
object Employees : Table<Employee>("t_employee") {
    val id by int("id").primaryKey().bindTo { it.id }
    val name by varchar("name").bindTo { it.name }
    val job by varchar("job").bindTo { it.job }
    val managerId by int("manager_id").bindTo { it.manager?.id }
    val hireDate by date("hire_date").bindTo { it.hireDate }
    val salary by long("salary").bindTo { it.salary }
    val departmentId by int("department_id").references(Departments) { it.department }
}