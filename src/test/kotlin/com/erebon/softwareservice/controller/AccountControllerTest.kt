package com.erebon.softwareservice.controller

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup
import org.springframework.web.context.WebApplicationContext
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*

@SpringBootTest
class AccountControllerTest{

    private val baseUrl = "http://localhost:8080/account/"

    private val jsonContentType = MediaType(MediaType.APPLICATION_JSON.type,
            MediaType.APPLICATION_JSON.subtype)

    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var webAppContext: WebApplicationContext

    @BeforeEach
    fun before() {
        mockMvc = webAppContextSetup(webAppContext).build()
    }

    @Test
    fun `1 - Get empty list of products`() {

        val request = get(baseUrl).contentType(jsonContentType)
        mockMvc.perform(request)
                .andExpect(status().isOk)
                .andExpect(content().json("[]", true))
    }




}