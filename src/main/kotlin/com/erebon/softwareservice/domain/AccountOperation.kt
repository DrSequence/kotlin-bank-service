package com.erebon.softwareservice.domain

import javax.persistence.*

@Entity
@Table(name = "operation")
data class AccountOperation(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @Column(name = "descr")
    var description: String = "",

    @OneToOne(mappedBy = "account", cascade = [CascadeType.ALL], fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    var account: Account? = null

)