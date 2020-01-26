package com.erebon.softwareservice.controller

import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController("/payment")
class PaymentController {

    @PutMapping
    fun pay(@RequestParam id: Long, @RequestParam coast: BigDecimal) = null

}