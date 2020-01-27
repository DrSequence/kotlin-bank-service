package com.erebon.softwareservice.domain

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "account")
data class Account(

        @Id
        @JsonProperty("id")
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0L,

        @Column(name = "number")
        val number: Number = 0,

        @JsonProperty("balance")
        @Column(name = "balance")
        val balance: BigDecimal = BigDecimal.ZERO,

        @JsonProperty("name")
        @Column(name = "name")
        val name: String = "",

        @JsonProperty("descr")
        @Column(name = "descr")
        val descr: String = "",

        @OneToMany(mappedBy = "account", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        val humans: List<Human>? = emptyList(),

        @OneToMany(mappedBy = "account", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
        val operations: List<AccountOperation> = emptyList()
) {
        override fun toString(): String {
                return "{name: ${this.name}, products: ${humans?.map { it -> it.name }}}";
        }
}