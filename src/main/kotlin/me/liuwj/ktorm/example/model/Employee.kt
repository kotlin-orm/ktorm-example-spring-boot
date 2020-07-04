package me.liuwj.ktorm.example.model

import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.entity.Entity
import me.liuwj.ktorm.entity.sequenceOf
import me.liuwj.ktorm.schema.*
import java.time.LocalDate

/**
 * The employee entity.
 */
interface Employee : Entity<Employee> {
    companion object : Entity.Factory<Employee>()

    /**
     * Employee ID.
     */
    var id: Int

    /**
     * The employee's name.
     */
    var name: String

    /**
     * The employee's job.
     */
    var job: String

    /**
     * The employee's manager.
     */
    var manager: Employee?

    /**
     * The employee's hire date.
     */
    var hireDate: LocalDate

    /**
     * The employee's salary.
     */
    var salary: Long

    /**
     * The employee's department.
     */
    var department: Department
}

/**
 * The employee table object.
 */
object Employees : Table<Employee>("t_employee") {

    /**
     * Employee ID.
     */
    val id = int("id").primaryKey().bindTo { it.id }

    /**
     * The employee's name.
     */
    val name = varchar("name").bindTo { it.name }

    /**
     * The employee's job.
     */
    val job = varchar("job").bindTo { it.job }

    /**
     * The manager's ID of the employee.
     */
    val managerId = int("manager_id").bindTo { it.manager?.id }

    /**
     * The employee's hire date.
     */
    val hireDate = date("hire_date").bindTo { it.hireDate }

    /**
     * The employee's salary.
     */
    val salary = long("salary").bindTo { it.salary }

    /**
     * The department's ID of the employee.
     */
    val departmentId = int("department_id").references(Departments) { it.department }
}

/**
 * Return a default entity sequence of [Departments].
 */
val Database.employees get() = this.sequenceOf(Employees)
