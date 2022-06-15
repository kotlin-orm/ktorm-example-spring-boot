package org.ktorm.example.dao

import org.ktorm.example.model.Department
import org.ktorm.example.model.Departments
import org.springframework.stereotype.Component

/**
 * Created by vince on Jun 15, 2022.
 */
@Component
class DepartmentDao : BaseDao<Department, Departments>(Departments)
