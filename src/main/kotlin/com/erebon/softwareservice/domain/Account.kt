package com.erebon.softwareservice.domain

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "account")
data class Account(

        @Id
        @JsonProperty("id")
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0L,

        val number: Number = 0,

        @JsonProperty("name")
        @Column(name = "name")
        val name: String = "",

        @JsonProperty("descr")
        @Column(name = "descr")
        val descr: String = ""
)