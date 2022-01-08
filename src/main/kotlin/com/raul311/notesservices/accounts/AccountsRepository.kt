package com.raul311.notesservices.accounts

import org.springframework.data.jpa.repository.JpaRepository

interface AccountsRepository : JpaRepository<Account, String>