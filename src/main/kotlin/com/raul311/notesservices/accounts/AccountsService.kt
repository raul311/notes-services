package com.raul311.notesservices.accounts

import org.springframework.stereotype.Service

@Service
class AccountsService(private val accountsRepository: AccountsRepository) {

    fun getAllAccounts(): List<Account> {
        println("getting all accounts")
//        var accounts = accountsRepository.findAccounts()
//        println("first pass $accounts")
        var accounts = accountsRepository.findAll().toList()
        println("second pass $accounts")
        return accounts
    }

    fun insertAccount(accountName: Account) {
        println("creating account $accountName")
        println("DB = $accountsRepository.toString()")
        if(!accountsRepository.existsById(accountName.name)) {
            println("$accountName does not exist, creating")
//            accountsRepository.createAccount(Account(accountName))
            accountsRepository.save(accountName)
            println("$accountName account has been created")
        } else {
            println("$accountName exists")
        }
    }

    fun updateAccount(oldAccount: String, newAccount: String) {
        if (accountsRepository.existsById(oldAccount)
                && !accountsRepository.existsById(newAccount)) {
            accountsRepository.deleteById(oldAccount)
            accountsRepository.save(Account(newAccount))
        }
    }

    fun deleteAccount(accountName: String) {
        if (accountsRepository.existsById(accountName)) {
            accountsRepository.deleteById(accountName)
        }
    }

    fun accountExist(accountName: String) : Boolean {
        return accountsRepository.existsById(accountName)
    }
}