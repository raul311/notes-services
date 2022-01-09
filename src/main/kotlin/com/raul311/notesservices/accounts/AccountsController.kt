package com.raul311.notesservices.accounts

import org.springframework.web.bind.annotation.*

@RestController
class AccountsController(private val accountsService: AccountsService) {

    @GetMapping
    fun getAllAccounts(): List<Account> = accountsService.getAllAccounts()

    @GetMapping(value = ["/accounts/isValid"])
    fun isAccountValid(@RequestBody account: Account): Boolean = accountsService.accountExist(account)

    @PostMapping(value = ["/accounts/create"])
    fun createAccount(@RequestBody accountName: String) = accountsService.insertAccount(accountName)

    @PostMapping(value = ["/accounts/update"])
    fun updateAccount(@RequestBody account: Account) = accountsService.updateAccount(account)

    @PostMapping(value = ["/accounts/delete"])
    fun deleteAccount(@RequestBody account: Account) = accountsService.deleteAccount(account)
}