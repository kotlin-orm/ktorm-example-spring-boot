package org.ktorm.example.model

import org.ktorm.entity.Entity
import org.ktorm.ksp.annotation.PrimaryKey
import org.ktorm.ksp.annotation.Table

/**
 * The department entity.
 */
@Table("t_department")
interface Department : Entity<Department> {

    /**
     * Department ID.
     */
    @PrimaryKey
    val id: Int

    /**
     * Department name.
     */
    var name: String

    /**
     * Department location.
     */
    var location: String
}
