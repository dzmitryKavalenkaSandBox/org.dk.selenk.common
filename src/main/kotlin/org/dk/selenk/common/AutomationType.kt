package org.dk.selenk.common

sealed class AutomationType(val type: String) {
    object Web : AutomationType("web")
    object UiAutomator2 : AutomationType("uiautomator2")
    object XcUiTest : AutomationType("XCUITest")
}
