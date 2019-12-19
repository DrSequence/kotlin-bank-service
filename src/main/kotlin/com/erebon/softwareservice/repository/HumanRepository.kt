package com.erebon.softwareservice.repository

import com.erebon.softwareservice.domain.Human
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface HumanRepository : JpaRepository<Human, Long>