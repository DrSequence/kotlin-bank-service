package com.erebon.softwareservice.service.repoLayer.impl

import com.erebon.softwareservice.domain.Account
import com.erebon.softwareservice.repository.AccountRepository
import com.erebon.softwareservice.service.repoLayer.AccountService
import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountServiceImpl(private val accountRepository: AccountRepository) : AccountService {

    override fun getAll(): Iterable<Account> {
        return accountRepository.findAll()
    }

    override fun get(id: Long): Optional<Account> {
        return accountRepository.findById(id);
    }

    override fun add(account: Account): Account {
        return accountRepository.save(account);
    }

    override fun edit(id: Long, account: Account) {
         accountRepository.save(account.copy(id = id))
        // Сохраняем копию объекта с указанным id в БД.
        // Идиоматика Kotlin говорит что НЕ изменяемый - всегда лучше чем изменяемый
        // (никто не поправит значение в другом потоке) и предлагает метод copy для копирования объектов
        // (специальных классов для хранения данных) с возможностью замены значений
    }

    override fun remove(id: Long) {
        return accountRepository.deleteById(id);
    }
}