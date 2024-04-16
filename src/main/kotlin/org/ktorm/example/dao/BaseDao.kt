package org.ktorm.example.dao

import org.ktorm.database.Database
import org.ktorm.entity.*
import org.ktorm.schema.ColumnDeclaring
import org.ktorm.schema.Table
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

/**
 * Created by vince on Jun 15, 2022.
 */
@Configuration
abstract class BaseDao<E : Entity<E>, T : Table<E>>(private val tableObject: T) {
    @Autowired
    protected lateinit var database: Database

    /**
     * Insert the given entity into the table and return the effected record number.
     */
    open fun add(entity: E): Int {
        return database.sequenceOf(tableObject).add(entity)
    }

    /**
     * Update properties of the given entity to the table and return the effected record number.
     */
    open fun update(entity: E): Int {
        return database.sequenceOf(tableObject).update(entity)
    }

    /**
     * Delete records that satisfy the given [predicate].
     */
    open fun deleteIf(predicate: (T) -> ColumnDeclaring<Boolean>): Int {
        return database.sequenceOf(tableObject).removeIf(predicate)
    }

    /**
     * Return true if all records match the given [predicate].
     */
    open fun allMatched(predicate: (T) -> ColumnDeclaring<Boolean>): Boolean {
        return database.sequenceOf(tableObject).all(predicate)
    }

    /**
     * Return true if at least one record match the given [predicate].
     */
    open fun anyMatched(predicate: (T) -> ColumnDeclaring<Boolean>): Boolean {
        return database.sequenceOf(tableObject).any(predicate)
    }

    /**
     * Return true if no records match the given [predicate].
     */
    open fun noneMatched(predicate: (T) -> ColumnDeclaring<Boolean>): Boolean {
        return database.sequenceOf(tableObject).none(predicate)
    }

    /**
     * Return the number of records in the table.
     */
    open fun count(): Int {
        return database.sequenceOf(tableObject).count()
    }

    /**
     * Return the number of records matching the given [predicate] in the table.
     */
    open fun count(predicate: (T) -> ColumnDeclaring<Boolean>): Int {
        return database.sequenceOf(tableObject).count(predicate)
    }

    /**
     * Return an entity object matching the given [predicate].
     */
    open fun findOne(predicate: (T) -> ColumnDeclaring<Boolean>): E? {
        return database.sequenceOf(tableObject).find(predicate)
    }

    /**
     * Return a list of entities matching the given [predicate].
     */
    open fun findList(predicate: (T) -> ColumnDeclaring<Boolean>): List<E> {
        return database.sequenceOf(tableObject).filter(predicate).toList()
    }

    /**
     * Return all entities in the table.
     */
    open fun findAll(): List<E> {
        return database.sequenceOf(tableObject).toList()
    }
}
