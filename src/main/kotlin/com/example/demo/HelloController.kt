package com.example.demo

import io.swagger.v3.oas.annotations.Operation
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
    // I want this to be included in OpenAPI model
    // but it cannot be annotated @ResponseBody as it uses "forward:".
    // SpringDoc won't pick a method without @ResponseBody by default.
    // It can be picked if there is SpringDocUtils.getConfig().addRestControllers(HelloController.class).
    @GetMapping("/")
    @Operation(summary = "root endpoint")
    fun hello(): String = "forward:/message"

    // This is included in OpenAPI model even without SpringDocUtils.getConfig().addRestControllers(HelloController.class).
    // Is it expected?
    @GetMapping("/message")
    @Operation(summary = "give some message")
    @ResponseBody
    fun message(): String = "hello"
}