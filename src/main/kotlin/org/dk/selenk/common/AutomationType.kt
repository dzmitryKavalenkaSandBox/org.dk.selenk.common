package org.dk.selenk.common

import org.dk.selenk.common.exception.ErrorCodeDefinition
import org.dk.selenk.common.exception.SelenKException

sealed class AutomationType(val type: String) {
    object Web : AutomationType("web")
    object UiAutomator2 : AutomationType("uiautomator2")
    object XcUiTest : AutomationType("XCUITest")


    companion object {
        fun fromString(platform: String): AutomationType =
            when (platform) {
                "UiAutomator2" -> UiAutomator2
                "uiautomator2" -> UiAutomator2
                "XcUiTest" -> XcUiTest
                "XCUITest" -> XcUiTest
                else -> throw SelenKException("Passed automation type '$platform' is not supported",
                    ErrorCodeDefinition.AUTOMATION_TYPE_NO_SUPPORTED)
            }
    }
}
