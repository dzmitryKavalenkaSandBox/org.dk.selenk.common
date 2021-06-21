package org.dk.selenk.common.attribute

import org.dk.selenk.common.AutomationType
import org.dk.selenk.common.SelenKConfig

@Suppress("PropertyName")
abstract class Attribute {

    internal abstract val WEB: String
    internal abstract val XCUITEST: String
    internal abstract val UIAUTOMATOR2: String

    fun attribute(automationType: AutomationType = SelenKConfig.automationType): String =
        when (automationType) {
            is AutomationType.Web -> WEB
            is AutomationType.XcUiTest -> XCUITEST
            is AutomationType.UiAutomator2 -> UIAUTOMATOR2
        }
}
