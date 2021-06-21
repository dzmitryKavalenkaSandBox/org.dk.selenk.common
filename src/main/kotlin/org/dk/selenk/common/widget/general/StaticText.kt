package org.dk.selenk.common.widget.general

import org.dk.selenk.common.AutomationType
import org.dk.selenk.common.SelenKConfig
import org.dk.selenk.common.widget.android.AndroidWidget
import org.dk.selenk.common.widget.ios.IOSWidget
import org.dk.selenk.common.widget.web.WebWidget

object StaticText : IOSWidget, AndroidWidget, WebWidget {

    override val WEB: String = "label"
    override val XCUITEST: String = "XCUIElementTypeStaticText"
    override val UIAUTOMATOR2: String = "android.org.dk.selenk.widget.TextView"

    override fun widget(): String =
        when (SelenKConfig.automationType) {
            is AutomationType.Web -> WEB
            is AutomationType.XcUiTest -> XCUITEST
            is AutomationType.UiAutomator2 -> UIAUTOMATOR2
        }
}
