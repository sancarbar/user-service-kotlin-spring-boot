package org.java.conference.users.service

import org.java.conference.users.data.User
import java.util.Optional

interface UserService {

    fun findUserById(id: String): Optional<User>

    fun updateUser(user: User): User

    fun create(user: User): User

    fun deleteById(id: String): Boolean

}