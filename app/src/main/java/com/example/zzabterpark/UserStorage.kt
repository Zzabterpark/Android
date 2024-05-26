package com.example.zzabterpark

data class User(val username: String, val password: String, val name: String)

object UserStorage {
    private val users = mutableMapOf<String, User>()
    private var loggedInUser: User? = null

    init {
        // 기본 테스트용 계정 생성
        users["qwe123"] = User("qwe123", "qwe123", "테스트")
    }

    fun register(username: String, password: String, name: String): Boolean {
        if (users.containsKey(username)) {
            return false
        }
        users[username] = User(username, password, name)
        return true
    }

    fun login(username: String, password: String): Boolean {
        val user = users[username]
        return if (user?.password == password) {
            loggedInUser = user
            true
        } else {
            false
        }
    }

    fun isLoggedIn(): Boolean {
        return loggedInUser != null
    }

    fun getLoggedInUser(): User? {
        return loggedInUser
    }

    fun getLoggedInUserName(): String? {
        return loggedInUser?.name
    }
}
