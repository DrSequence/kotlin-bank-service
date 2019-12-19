package com.erebon.softwareservice.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.*

@Entity
@Table(name = "human")
data class Human(

        @Id
        @JsonProperty("id")
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE)
        var id: Long = 0L,

        @Column(name = "name", scale = 10)
        @JsonProperty("name")
        var name: String = "",

        @Column(name = "surname", scale = 10)
        @JsonProperty("surname")
        var surname: String = "",

        @Column(name = "lastName", scale = 10)
        @JsonProperty("lastName")
        var lastName: String = "",

        @Column(name = "phone", scale = 10, unique = true)
        @JsonProperty("phone")
        var phone: String = "",

        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "account_id")
        var account: Account? = null

)