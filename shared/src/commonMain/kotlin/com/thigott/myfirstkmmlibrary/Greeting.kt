package com.thigott.myfirstkmmlibrary

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello Library, ${platform.name}!"
    }
}