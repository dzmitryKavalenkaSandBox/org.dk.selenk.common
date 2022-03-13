package org.dk.selenk.common

import org.dk.selenk.common.exception.ErrorCodeDefinition
import org.dk.selenk.common.exception.SelenKException

@Suppress("ClassName")
sealed class Platform(val type: String, val name: String) {

    object AndroidSmart : Platform("AndroidSmartphone", "android")
    object AndroidTab : Platform("AndroidTablet", "android")
    object iPhone : Platform("iPhone", "ios")
    object iPad : Platform("iPad", "ios")
    object Web : Platform("Web", "web")

    override fun toString(): String {
        return "Platform(type='$type', name='$name')"
    }

    companion object {
        fun fromString(platform: String): Platform =
            when (platform) {
                "AndroidSmart" -> AndroidSmart
                "AndroidSmartphone" -> AndroidSmart
                "AndroidTab" -> AndroidTab
                "AndroidTablet" -> AndroidTab
                "iPhone" -> iPhone
                "iPad" -> iPad
                else -> throw SelenKException("Passed platform '$platform' is not supported",
                    ErrorCodeDefinition.PLATFORM_NOT_SUPPORTED)
            }
    }
}
