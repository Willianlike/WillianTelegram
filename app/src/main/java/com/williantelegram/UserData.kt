package com.williantelegram

import java.io.Serializable

class UserData(val id: String, val name: String, val year: String): Serializable

enum class UserDataSortType {
    NAME, YEAR
}

fun List<UserData>.sorted(byType: UserDataSortType): List<UserData> {
    return when (byType) {
        UserDataSortType.NAME ->
            this.sortedBy { it.name }
        UserDataSortType.YEAR ->
            this.sortedBy { it.year }
    }
}

class KK {
    fun gg() {
        val kk = mutableListOf<UserData>()
        kk.add(UserData("1", "Me", "321"))
        kk.add(UserData("2", "You", "123"))
        println(kk.sorted(UserDataSortType.NAME).map {it.id})
        println(kk.sorted(UserDataSortType.YEAR).map {it.id})
    }
}
