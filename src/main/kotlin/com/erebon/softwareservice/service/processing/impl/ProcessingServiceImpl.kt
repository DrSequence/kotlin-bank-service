package com.erebon.softwareservice.service.processing.impl

import com.erebon.softwareservice.domain.Account
import com.erebon.softwareservice.repository.AccountRepository
import com.erebon.softwareservice.service.processing.ProcessingService
import org.springframework.stereotype.Service
import java.math.BigDecimal
import javax.management.BadAttributeValueExpException

@Service
class ProcessingServiceImpl(private val accountRepository: AccountRepository) : ProcessingService {

    override fun pay(id: Long, coast: BigDecimal): Account {
        val account = accountRepository.getOne(id)
        if (account.balance > coast) {
            account.balance.minus(coast)
            return accountRepository.save(account)
        } else {
            throw BadAttributeValueExpException("Balance more then coast")
        }
    }

}