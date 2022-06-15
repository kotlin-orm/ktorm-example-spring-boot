package org.ktorm.example.dto

/**
 * Created by vince on Jun 15, 2022.
 */
data class PageDTO<T>(
    val modelList: List<T>,
    val totalRecords: Int,
    val startIndex: Int,
    val pageSize: Int,
    val pageCount: Int = if (totalRecords % pageSize == 0) totalRecords / pageSize else totalRecords / pageSize + 1
)