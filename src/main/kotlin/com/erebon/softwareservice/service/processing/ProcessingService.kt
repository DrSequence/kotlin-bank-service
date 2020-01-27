package com.erebon.softwareservice.service.processing

import com.erebon.softwareservice.domain.Account
import java.math.BigDecimal

interface ProcessingService {

    fun pay(id: Long, coast: BigDecimal): Account

}