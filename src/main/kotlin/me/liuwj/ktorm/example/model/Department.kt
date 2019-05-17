package me.liuwj.ktorm.example.model

import me.liuwj.ktorm.entity.Entity

/**
 * Created by vince on May 17, 2019.
 */
interface Department : Entity<Department> {
    companion object : Entity.Factory<Department>()
    val id: Int
    var name: String
    var location: String
}