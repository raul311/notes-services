package com.raul311.notesservices.accounts

import javax.persistence.*

@Entity
@Table(name = "accounts")
data class Account(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", unique = true, nullable = false)
        var id: Long = 0,
        @Column(name = "name", unique = true, nullable = false)
        val name: String
        )