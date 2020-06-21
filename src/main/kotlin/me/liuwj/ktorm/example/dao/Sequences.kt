package me.liuwj.ktorm.example.dao

import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.entity.sequenceOf

val Database.departments get() = this.sequenceOf(Departments)

val Database.employees get() = this.sequenceOf(Employees)
