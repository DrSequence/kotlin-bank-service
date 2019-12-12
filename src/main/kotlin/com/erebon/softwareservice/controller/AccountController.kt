package com.erebon.softwareservice.controller

import com.erebon.softwareservice.service.AccountService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/account")
class AccountController (private val accountService: AccountService) {

    @GetMapping
    fun index() = accountService.getAll();

    



}