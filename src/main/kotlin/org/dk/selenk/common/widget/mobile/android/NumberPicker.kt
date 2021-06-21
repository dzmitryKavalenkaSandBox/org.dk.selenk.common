package org.dk.selenk.common.widget.mobile.android

import org.dk.selenk.common.AutomationType
import org.dk.selenk.common.SelenKConfig

object NumberPicker: UiAutomator2Widget {

    override val UIAUTOMATOR2: String = "android.widget.NumberPicker"

    override fun widget(): String =
        when (SelenKConfig.automationType) {
            is AutomationType.UiAutomator2 -> UIAUTOMATOR2
            else -> throw widgetNoSupportedOnPlatformExceptionProvider()
        }
}
