package com.erebon.softwareservice.service

import com.erebon.softwareservice.domain.Account
import java.util.*

interface AccountService {

    fun getAll(): Iterable<Account>

    fun get(id: Long): Optional<Account>

    fun add(account: Account): Account

    fun edit(id: Long, account: Account): Account

    fun remove(id: Long)
}