package org.ktorm.example.configuration

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer
import org.ktorm.database.Database
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Created by watson on May 17, 2021.
 */
@Configuration
class LocalDateTimeSerializerConfig {
    /**
     * Change the jackson configuration date-format setting.
     */
    @Value("\${spring.jackson.date-format:yyyy-MM-dd HH:mm:ss}")
    private val pattern: String? = null

    @Bean
    fun localDateTimeDeserializer(): LocalDateTimeSerializer? {
        return LocalDateTimeSerializer(DateTimeFormatter.ofPattern(pattern))
    }

    @Bean
    fun jackson2ObjectMapperBuilderCustomizer(): Jackson2ObjectMapperBuilderCustomizer? {
        return Jackson2ObjectMapperBuilderCustomizer { builder: Jackson2ObjectMapperBuilder ->
            builder.serializerByType(
                LocalDateTime::class.java, localDateTimeDeserializer()!!
            )
        }
    }
}