package com.erebon.softwareservice.repository

import com.erebon.softwareservice.domain.AccountOperation
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OperationRepository : JpaRepository<AccountOperation, Long>