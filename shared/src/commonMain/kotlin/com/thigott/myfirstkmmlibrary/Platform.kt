package com.thigott.myfirstkmmlibrary

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform