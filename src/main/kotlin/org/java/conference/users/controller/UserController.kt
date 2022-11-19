package org.java.conference.users.controller

import org.java.conference.users.data.User
import org.java.conference.users.data.UserDto
import org.java.conference.users.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/user")
class UserController(@Autowired val userService: UserService) {


    @GetMapping("/{id}")
    fun getUserName(@PathVariable id: String): User? {

        val userOptional = userService.findUserById(id)
        return if (userOptional.isPresent)
            userOptional.get()
        else
            null
    }

    @PostMapping
    fun createNewUser(@RequestBody userDto: UserDto): User {
        return userService.create(User(userDto))
    }

//    @PutMapping

//    @DeleteMapping

}