package com.erebon.softwareservice.service.repoLayer.impl

import com.erebon.softwareservice.domain.Human
import com.erebon.softwareservice.repository.HumanRepository
import com.erebon.softwareservice.service.repoLayer.HumanService
import org.springframework.stereotype.Service
import java.util.*

@Service
class HumanServiceImpl(private val humanRepository: HumanRepository) : HumanService {

    override fun getAll() : Iterable<Human> {
        return humanRepository.findAll();
    }

    override fun get(id: Long): Optional<Human> {
        return humanRepository.findById(id);
    }

    override fun add(human: Human): Human {
        return humanRepository.save(human);
    }

    override fun edit(id: Long, human: Human): Human {
        return humanRepository.save(human.copy(id = id))
        // Сохраняем копию объекта с указанным id в БД.
        // Идиоматика Kotlin говорит что НЕ изменяемый - всегда лучше чем изменяемый
        // (никто не поправит значение в другом потоке) и предлагает метод copy для копирования объектов
        // (специальных классов для хранения данных) с возможностью замены значений
    }

    override fun remove(id: Long) {
        return humanRepository.deleteById(id);
    }

}