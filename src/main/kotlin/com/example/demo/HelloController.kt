package com.example.demo

import io.swagger.v3.oas.annotations.Operation
import org.springdoc.core.SpringDocUtils
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

// Created 2021/1/14 20:12

/**
 *
 * @author Azige
 */
// The class can not be @RestController or every method is implicit @ResponseBody
@Controller
class HelloController {
    companion object {
        init {
            // if this is commented, DemoApplicationTests.rootPathShouldBeIncludedInOpenApiModel will fail.
            SpringDocUtils.getConfig().addRestControllers(HelloController::class.java)
        }
    }

    // I want this to be included in OpenAPI model
    // but it cannot be annotated @RequestBody as it uses "forward:".
    // SpringDoc won't pick a method without @ResponseBody by default.
    // It can be picked if there is SpringDocUtils.getConfig().addRestControllers(HelloController.class).
    // But as long as I annotate it @Operation, I expect it get picked by default.
    // Why I have to provide extra configurations?
    @GetMapping("/")
    @Operation(summary = "root endpoint")
    fun hello(): String = "forward:/message"

    // This is included in OpenAPI model as expected
    // even without SpringDocUtils.getConfig().addRestControllers(HelloController.class)
    @GetMapping("/message")
    @Operation(summary = "give some message")
    @ResponseBody
    fun message(): String = "hello"
}