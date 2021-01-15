package com.example.demo

import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

// Created 2021/1/15 19:53

/**
 *
 * @author Azige
 */
@RestController
class DemoRestController {
    @GetMapping("/demo")
    @Operation(summary = "a demo endpoint")
    fun demo() = "demo"
}