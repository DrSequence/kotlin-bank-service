package com.erebon.softwareservice.controller

import com.erebon.softwareservice.domain.Account
import com.erebon.softwareservice.service.operationLog.OperationService
import com.erebon.softwareservice.service.processing.ProcessingService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import javax.validation.constraints.NotNull

@RestController("/payment")
class PaymentController(private val operationService: OperationService,
                        private val processingService : ProcessingService) {

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun pay(@NotNull @RequestParam id: Long, @NotNull @RequestParam coast: BigDecimal,
            @RequestParam descr: String) : Account {
        val account = processingService.pay(id, coast)
        operationService.save(account, descr)
        return account
    }

}