package com.raul311.notesservices.accounts

import org.springframework.stereotype.Service

@Service
class AccountsService(private val accountsRepository: AccountsRepository) {

    fun getAllAccounts(): List<Account> = accountsRepository.findAll().toList()

    fun insertAccount(accountName: String) {
        println("creating account $accountName")
        if(!accountExistByName(accountName)) {
            accountsRepository.save(Account(name = accountName))
            println("$accountName account has been created")
        } else {
            println("$accountName exists")
        }
    }

    fun updateAccount(account: Account) {
        if (accountsRepository.existsById(account.id)) {
            accountsRepository.save(account)
        }
    }

    fun deleteAccount(account: Account) {
        if (accountsRepository.existsById(account.id)) {
            accountsRepository.deleteById(account.id)
        }
    }

    fun accountExist(accountName: Account) : Boolean = accountsRepository.existsById(accountName.id)

    fun accountExistByName(accountName: String) : Boolean = accountsRepository.countAccountsByName(accountName) != 0L

}