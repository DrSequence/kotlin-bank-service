package com.erebon.softwareservice.service.operationLog

import com.erebon.softwareservice.domain.Account
import com.erebon.softwareservice.domain.AccountOperation
import com.erebon.softwareservice.repository.OperationRepository
import org.springframework.stereotype.Service

@Service
class OperationService(private val operationRepository: OperationRepository) {

    fun save(account: Account, descr: String) {
        val operation = AccountOperation()
        operation.description = descr
        operation.account = account
        operationRepository.saveAndFlush(operation)
    }
}