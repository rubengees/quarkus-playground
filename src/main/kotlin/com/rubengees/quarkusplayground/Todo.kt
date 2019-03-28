package com.rubengees.quarkusplayground

data class Todo(
    val id: Long,
    val name: String,
    val description: String,
    val done: Boolean
)
