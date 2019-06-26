package me.liuwj.ktorm.example.configuration

import com.fasterxml.jackson.databind.Module
import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.jackson.KtormModule
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

/**
 * Created by vince on May 17, 2019.
 */
@Configuration
class KtormConfiguration {
    @Autowired
    lateinit var dataSource: DataSource

    @Bean
    fun database(): Database {
        return Database.connectWithSpringSupport(dataSource)
    }

    @Bean
    fun ktormModule(): Module {
        return KtormModule()
    }
}