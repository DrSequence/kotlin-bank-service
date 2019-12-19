package com.erebon.softwareservice.service.repoLayer

import com.erebon.softwareservice.domain.Human
import java.util.*

interface HumanService {

    fun getAll(): Iterable<Human>
    fun get(id: Long): Optional<Human>
    fun add(human: Human): Human
    fun edit(id: Long, human: Human): Human
    fun remove(id: Long)
}