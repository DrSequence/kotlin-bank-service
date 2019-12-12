package com.erebon.softwareservice.repository

import com.erebon.softwareservice.domain.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, Long>