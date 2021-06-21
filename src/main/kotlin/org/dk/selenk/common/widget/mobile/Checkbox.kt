package org.dk.selenk.common.widget.mobile

import org.dk.selenk.common.AutomationType
import org.dk.selenk.common.SelenKConfig
import org.dk.selenk.common.widget.mobile.android.UiAutomator2Widget
import org.dk.selenk.common.widget.mobile.ios.XcUiWidget

object Checkbox : UiAutomator2Widget, XcUiWidget {

    override val XCUITEST: String = "XCUIElementTypeStaticText"
    override val UIAUTOMATOR2: String = "android.widget.TextView"

    override fun widget(): String =
        when (SelenKConfig.automationType) {
            is AutomationType.XcUiTest -> XCUITEST
            is AutomationType.UiAutomator2 -> UIAUTOMATOR2
            else -> throw widgetNoSupportedOnPlatformExceptionProvider()
        }
}
