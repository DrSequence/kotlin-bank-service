package com.erebon.softwareservice.controller

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup
import org.springframework.web.context.WebApplicationContext

@SpringBootTest
class AccountControllerTest{

    private val baseUrl = "http://localhost:8080/accounts/"

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
    fun `1 - Get empty list of product`() {
        val request = get(baseUrl).contentType(jsonContentType)
        mockMvc.perform(request)
                .andExpect(status().isOk)
                .andExpect(content().json("[]", true))
    }

    @Test
    fun `2 - Post new account`() {
        val passedJsonString = """
            {
                "number": 1,
                "name": "Kopilka",
                "descr": "Sberbank project"
            }
        """.trimIndent()

        val request = post(baseUrl)
                .contentType(jsonContentType)
                .content(passedJsonString)

        val resultJsonString = """
            {
                "id": 1,
                "number": 1,
                "name": "Kopilka",
                "descr": "Sberbank project"
            }
        """.trimIndent()

        mockMvc.perform(request)
                .andExpect(status().isCreated)
                .andExpect(content().json(resultJsonString, true))
    }

    @Test
    fun `3 - Update first account`() {
        val passedJsonString = """
            {
                "number": 1,
                "name": "Kopilka",
                "descr": "Sberbank project"
            }
        """.trimIndent()

        val request = put(baseUrl + "1")
                .contentType(jsonContentType).content(passedJsonString)

        val resultJsonString = """
            {
                "id": 1,
                "number": 1,
                "name": "Kopilka",
                "descr": "Sberbank project"
            }
        """.trimIndent()

        mockMvc.perform(request)
                .andExpect(status().isOk)
                .andExpect(content().json(resultJsonString, true))
    }

    @Test
    fun `4 - Find first account`() {
        val request = get(baseUrl + "1").contentType(jsonContentType)

        val resultJsonString = """
            {
                "id": 1,
                "number": 1,
                "name": "Kopilka",
                "descr": "Sberbank project"
            }
        """.trimIndent()

        mockMvc.perform(request)
                .andExpect(status().isFound)
                .andExpect(content().json(resultJsonString, true))
    }

    @Test
    fun `5 - Delete first account`() {
        val request = delete(baseUrl + "1").contentType(jsonContentType)

        mockMvc.perform(request).andExpect(status().isOk)
    }






}