package org.dk.selenk.common.widget.mobile.android

import org.dk.selenk.common.AutomationType
import org.dk.selenk.common.SelenKConfig

object ViewGroup: UiAutomator2Widget {

    override val UIAUTOMATOR2: String = "android.view.ViewGroup"

    override fun widget(): String =
        when (SelenKConfig.automationType) {
            is AutomationType.UiAutomator2 -> UIAUTOMATOR2
            else -> throw widgetNoSupportedOnPlatformExceptionProvider()
        }
}
