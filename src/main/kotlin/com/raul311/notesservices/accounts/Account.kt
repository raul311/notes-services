package com.raul311.notesservices.accounts

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "accounts")
data class Account(
        @Column(name = "name", unique = true, nullable = false)
        @Id val name: String
        )