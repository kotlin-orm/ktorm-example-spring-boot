package org.ktorm.example.dto

/**
 * Created by vince on Jun 15, 2022.
 */
data class PageDTO<T>(
    val modelList: List<T>,
    val totalRecordsInAllPages: Int,
    val startIndex: Int,
    val pageSize: Int,
    val pageCount: Int =
        if (totalRecordsInAllPages % pageSize == 0) {
            totalRecordsInAllPages / pageSize
        } else {
            totalRecordsInAllPages / pageSize + 1
        }
)