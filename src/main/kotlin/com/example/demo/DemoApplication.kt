package com.example.demo

import io.swagger.v3.oas.models.PathItem
import org.springdoc.core.SpringDocUtils
import org.springdoc.core.customizers.OpenApiCustomiser
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
