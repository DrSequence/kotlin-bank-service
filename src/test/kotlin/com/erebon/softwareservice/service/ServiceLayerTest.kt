package com.erebon.softwareservice.service

import com.erebon.softwareservice.domain.Account
import com.erebon.softwareservice.domain.Human
import com.erebon.softwareservice.repository.AccountRepository
import com.erebon.softwareservice.repository.HumanRepository
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ServiceLayerTest {

    @Autowired lateinit var accountRepository: AccountRepository
    @Autowired lateinit var humanRepository: HumanRepository

    @Test
    fun `1 - create account and human and save`() {
        val sberAccount = Account(0L, 1231313, "Sber", "Sber kopilka")

        val alfaAccount = Account(0L, 1312343, "Alfa", "Alfa cap")

        val humanSberFirst = Human(0L, "Ivan", "Ivanov", "Ivanovich",
                "+79991112233", sberAccount)

        val humanSberSecond = Human(0L, "Petr", "Petrov", "Petrovich",
                "+79995554433", sberAccount)

        val humanAlfaFirst = Human(0L, "Ilia", "iliyin", "Ilich",
                "+79998889900", alfaAccount)

        val humanAlfaSecond = Human(0L, "Atrem", "Artemov", "Artemovoch",
                "+79991234566", alfaAccount)

        accountRepository.saveAll(setOf(sberAccount, alfaAccount))

        humanRepository.saveAll(setOf(humanSberFirst, humanSberSecond))
        humanRepository.saveAll(setOf(humanAlfaFirst, humanAlfaSecond))
    }

    @Test
    fun `2 -  get all avail accounts`() {
        val accountWithHumans = accountRepository.findAll()
        assertNotNull(accountWithHumans)
    }

}