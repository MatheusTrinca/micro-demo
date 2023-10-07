package com.example.controller

import com.example.model.Address
import com.example.model.AppUser
import com.example.model.request.AppUserRequest
import com.example.model.request.SearchRequest
import com.example.service.AppUserService
import io.micronaut.data.annotation.Id
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.HttpMethodMapping
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import io.micronaut.http.annotation.Status

@Controller("/users")
class AppUserController(
    private val appUserService: AppUserService
) {

    @Post
    @Status(HttpStatus.CREATED)
    fun create(@Body appUserRequest: AppUserRequest) =
        appUserService.create(appUser = appUserRequest.toModel())

    @Get
    fun getAll(): List<AppUser> {
        return appUserService.getAll()
    }

//    Trocando o path por outro nome de variável, whatever para id nesse caso
//    @Get("/{whatever}")
//    fun getById(@PathVariable("whatever") id: String): AppUser {
//        return appUserService.getById(id)
//    }

    @Get("/{id}")
    fun getById(id: String): AppUser {
        return appUserService.getById(id)
    }

    @Put("/{id}")
    fun update(id: String, @Body appUser: AppUserRequest, @Header("X-Foo") header: String): AppUser {
        println("HEADER $header")
        return appUserService.update(id, appUser.toModel())
    }

    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    fun delete(id: String) {
        return appUserService.delete(id)
    }

    @Post("/search")
    fun search(@Body searchRequest: SearchRequest): List<AppUser> {
        return appUserService.search(searchRequest)
    }

}