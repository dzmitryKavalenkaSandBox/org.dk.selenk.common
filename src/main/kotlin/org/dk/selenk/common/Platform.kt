package org.dk.selenk.common

@Suppress("ClassName")
sealed class Platform(val type: String, val name: String) {
    object AndroidSmart : Platform("Smartphone", "android")
    object AndroidTab : Platform("Tablet", "android")
    object iPhone : Platform("iPhone", "ios")
    object iPad : Platform("iPad", "ios")
    object Web : Platform("Web", "web")

    override fun toString(): String {
        return "Platform(type='$type', name='$name')"
    }


}
