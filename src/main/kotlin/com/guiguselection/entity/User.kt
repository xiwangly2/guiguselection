package com.guiguselection.entity

import jakarta.persistence.*

@Entity
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val avatar: String,

    val descrip: String,

    val username: String,
    val passwd: String,

    @ElementCollection
    val roles: List<String>,

    @ElementCollection
    val buttons: List<String>,

    @ElementCollection
    val routes: List<String>,

    val token: String
) {
    // 无参数构造函数
    constructor() : this(0, "", "", "", "", emptyList(), emptyList(), emptyList(), "")
}
