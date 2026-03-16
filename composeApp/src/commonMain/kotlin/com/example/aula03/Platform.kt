package com.example.aula03

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform