package org.ktorm.example.model

import org.ktorm.entity.Entity
import org.ktorm.ksp.annotation.PrimaryKey
import org.ktorm.ksp.annotation.References
import org.ktorm.ksp.annotation.Table
import java.time.LocalDate

/**
 * The employee entity.
 */
@Table("t_employee")
interface Employee : Entity<Employee> {

    /**
     * Employee ID.
     */
    @PrimaryKey
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
    var managerId: Int?

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
    @References
    var department: Department
}
