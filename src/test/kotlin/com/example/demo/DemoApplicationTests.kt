package com.example.demo

import org.hamcrest.Matchers.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

@SpringBootTest
class DemoApplicationTests {

    lateinit var mockMvc: MockMvc

    @BeforeEach
    fun setTup(context: WebApplicationContext) {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build()
    }

    @Test
    fun rootMappingShouldBeForwarded() {
        mockMvc.get("/").andExpect {
            forwardedUrl("/message")
        }
    }

    @Test
    fun rootPathShouldBeIncludedInOpenApiModel() {
        mockMvc.get("/v3/api-docs").andExpect {
            jsonPath("paths", hasKey("/"))
        }
    }

    @Test
    fun messagePathShouldBeIncludedInOpenApiModel() {
        mockMvc.get("/v3/api-docs").andExpect {
            jsonPath("paths", hasKey("/message"))
        }
    }
}
