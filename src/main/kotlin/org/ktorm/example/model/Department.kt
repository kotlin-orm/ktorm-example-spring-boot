package me.liuwj.ktorm.example.model

import org.ktorm.database.Database
import org.ktorm.entity.Entity
import org.ktorm.entity.sequenceOf
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar

/**
 * The department entity.
 */
interface Department : Entity<Department> {
    companion object : Entity.Factory<Department>()

    /**
     * Department ID.
     */
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

/**
 * The department table object.
 */
object Departments : Table<Department>("t_department") {

    /**
     * Department ID.
     */
    val id = int("id").primaryKey().bindTo { it.id }

    /**
     * Department name.
     */
    val name = varchar("name").bindTo { it.name }

    /**
     * Department location.
     */
    val location = varchar("location").bindTo { it.location }
}

/**
 * Return a default entity sequence of [Departments].
 */
val Database.departments get() = this.sequenceOf(Departments)
