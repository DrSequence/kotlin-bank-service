package com.erebon.softwareservice.controller

import com.erebon.softwareservice.domain.Account
import com.erebon.softwareservice.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController()
@RequestMapping("accounts")
class AccountController (private val accountService: AccountService) {

    @GetMapping
    fun index() = accountService.getAll()

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody account: Account) = accountService.add(account)

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.FOUND)
    fun get(@PathVariable id : Long) = accountService.get(id);

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(@PathVariable id: Long, @RequestBody account: Account) = accountService.edit(id, account)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = accountService.remove(id);
}