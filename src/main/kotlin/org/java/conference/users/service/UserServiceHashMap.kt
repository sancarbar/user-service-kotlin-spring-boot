package org.java.conference.users.service

import org.java.conference.users.data.User
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.atomic.AtomicLong
import kotlin.collections.HashMap

@Service
class UserServiceHashMap: UserService {

    private val users = HashMap<Long,User>()

    private val atomicLong = AtomicLong(1)

    override fun findUserById(id: String): Optional<User> {
        val userId = id.toLong()
        return if(users.containsKey(userId))
            Optional.of(users[userId]!!)
        else
            Optional.empty()
    }

    override fun updateUser(user: User): User {
        TODO("Not yet implemented")
    }

    override fun create(user: User): User {
        val userId = atomicLong.getAndIncrement()
        val newUser = User(userId, user.name, user.email)
        users[userId] = newUser
        return newUser
    }

    override fun deleteById(id: String): Boolean {
        TODO("Not yet implemented")
    }
}