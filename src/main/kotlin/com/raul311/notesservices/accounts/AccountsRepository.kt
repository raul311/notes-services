package com.raul311.notesservices.accounts

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface AccountsRepository : JpaRepository<Account, Long> {

    @Query("SELECT Count(a) FROM Account a WHERE a.name = ?1")
    fun countAccountsByName(accountName: String): Long

}