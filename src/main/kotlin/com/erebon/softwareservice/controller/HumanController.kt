package com.erebon.softwareservice.controller

import com.erebon.softwareservice.domain.Human
import com.erebon.softwareservice.repository.HumanRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/humans")
class HumanController(private val humanRepository: HumanRepository) {

    @GetMapping
    fun index(): MutableList<Human> = humanRepository.findAll();

}