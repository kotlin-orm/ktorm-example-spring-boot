package org.ktorm.example.model


import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.timestamp
import org.ktorm.schema.varchar
import java.time.Instant
import kotlin.reflect.KClass

/**
 * The BaseEntity class has some public files
 */
interface BaseEntity<E : BaseEntity<E>> : Entity<E> {

    /**
     *  what time is created the record
     */
    var createdDate: Instant?

    /**
     * who created the record
     */
    var createdBy: String?

    /**
     * what time is modified the record
     */
    var lastModifiedDate: Instant?

    /**
     * who modified the record
     */
    var lastModifiedBy: String?
}

/**
 * The BaseTable Class is used to bind fields
 * @param tableName tablename
 * @param alias alias
 * @param catalog catalog
 * @param schema schema
 * @param entityClass class
 */
abstract class BaseTable<E : BaseEntity<E>>(
    tableName: String,
    alias: String? = null,
    catalog: String? = null,
    schema: String? = null,
    entityClass: KClass<E>? = null
) : Table<E>(tableName, alias, catalog, schema, entityClass) {
    /**
     *  bind with the filed named created_date that in the database
     */
    val createdDate = timestamp("created_date").bindTo { it.createdDate }

    /**
     * bind with the filed named created_by that in the database
     */
    val createdBy = varchar("created_by").bindTo { it.createdBy }

    /**
     * bind with the filed named last_modified_date that in the database
     */
    val lastModifiedDate = timestamp("last_modified_date").bindTo { it.lastModifiedDate }

    /**
     * bind with the filed named last_modified_by that in the database
     */
    val lastModifiedBy = varchar("last_modified_by").bindTo { it.lastModifiedBy }
}