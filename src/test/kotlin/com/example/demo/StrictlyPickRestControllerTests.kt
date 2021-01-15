package com.example.demo

import org.hamcrest.Matchers.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

// Created 2021/1/15 19:58

/**
 *
 * @author Azige
 */
@SpringBootTest
class StrictlyPickRestControllerTests {

    lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setTup(context: WebApplicationContext) {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build()
    }

    @Test
    fun rootPathShouldNotBeIncludedInOpenApiModel() {
        mockMvc.get("/v3/api-docs").andExpect {
            jsonPath("paths", not(hasKey("/")))
        }
    }

    @Test
    fun messagePathShouldNotBeIncludedInOpenApiModel() {
        mockMvc.get("/v3/api-docs").andExpect {
            jsonPath("paths", not(hasKey("/message")))
        }
    }

    @Test
    fun demoPathShouldBeIncludedInOpenApiModel() {
        mockMvc.get("/v3/api-docs").andExpect {
            jsonPath("paths", hasKey("/demo"))
        }
    }
}