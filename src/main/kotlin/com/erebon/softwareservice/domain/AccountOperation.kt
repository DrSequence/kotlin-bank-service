package com.erebon.softwareservice.domain

import javax.persistence.*

@Entity
@Table(name = "operation")
data class AccountOperation(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @Column(name = "descr")
    val description: String = "",

    @OneToOne(mappedBy = "account", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    val account: Account? = null

)