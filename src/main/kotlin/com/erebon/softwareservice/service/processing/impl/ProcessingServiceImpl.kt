package com.erebon.softwareservice.service.processing.impl

import com.erebon.softwareservice.domain.Account
import com.erebon.softwareservice.repository.AccountRepository
import com.erebon.softwareservice.service.processing.ProcessingService
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProcessingServiceImpl(private val accountRepository: AccountRepository) : ProcessingService {

    fun pay() = null;


}