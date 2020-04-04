package com.erebon.softwareservice.domain

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "card")
data class Card(

        @Id
        @JsonProperty("id")
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        var id: Long = 0L,

        @Column(name = "descr", scale = 10)
        @JsonProperty("descr")
        var descr: String = ""

)