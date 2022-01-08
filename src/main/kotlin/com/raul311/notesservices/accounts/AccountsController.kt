package com.raul311.notesservices.accounts

import org.springframework.web.bind.annotation.*

@RestController
class AccountsController(private val accountsService: AccountsService) {

    @GetMapping(value = ["/test"])
    fun getAccounts(): List<Account> = listOf(
            Account("test 4"),
            Account("test 5"),
            Account("test 6")
    )

    @GetMapping
    fun index(): List<Account> = accountsService.getAllAccounts()

    @PostMapping
    fun post(@RequestBody account: Account) {
        accountsService.insertAccount(account)
    }

    @GetMapping(value = ["/accounts/isValid/{name}"])
    fun isValid(@PathVariable("name") name: String): Boolean = accountsService.accountExist(name)

    @PostMapping(value = ["/accounts/create"])
//    fun create(@PathVariable("name") name: Account) = accountsService.insertAccount(name)
    fun create(@RequestBody name: Account) = accountsService.insertAccount(name)


}