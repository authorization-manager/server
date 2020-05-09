package com.github.kerberos.authorizationservice.primaryadapter.rest.springwebmvc.role.create

import com.github.kerberos.authorizationservice.interaction.cqrs.CommandBus
import com.github.kerberos.authorizationservice.interaction.role.create.CreateRoleCommand
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class CreateRoleController(
    private val commandBus: CommandBus
) {
    @PostMapping("/roles")
    @ResponseStatus(CREATED)
    fun createRole(@RequestBody body: CreateRoleBody) {
        commandBus.dispatch(
            CreateRoleCommand(
                name = body.name,
                description = body.description
            )
        )
    }
}
