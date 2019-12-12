package com.erebon.softwareservice.controller

import com.erebon.softwareservice.domain.Account
import com.erebon.softwareservice.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/account")
class AccountController (private val accountService: AccountService) {

    @GetMapping
    fun index() = accountService.getAll();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody account: Account) = accountService.add(account)

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    fun get(@RequestParam id : Long) = accountService.get(id);

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun update(@RequestParam id: Long, @RequestParam account: Account) = accountService.edit(id, account)

    @DeleteMapping
    fun delete(@RequestParam id: Long) = accountService.remove(id);
}