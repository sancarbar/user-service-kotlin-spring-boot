package org.java.conference.users.data

data class User(val id: Long, val name: String, val email: String) {
    constructor(userDto: UserDto) : this(0, userDto.name, userDto.email)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false
        if (name != other.name) return false
        if (email != other.email) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + email.hashCode()
        return result
    }


}
