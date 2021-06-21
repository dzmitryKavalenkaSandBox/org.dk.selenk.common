package org.dk.selenk.common.widget.general

import org.dk.selenk.common.AutomationType
import org.dk.selenk.common.SelenKConfig
import org.dk.selenk.common.widget.mobile.android.UiAutomator2Widget
import org.dk.selenk.common.widget.mobile.ios.XcUiWidget
import org.dk.selenk.common.widget.web.WebWidget

object Image : XcUiWidget, UiAutomator2Widget, WebWidget {

    override val WEB: String = "image"
    override val XCUITEST: String = "XCUIElementTypeImage"
    override val UIAUTOMATOR2: String = "android.widget.ImageView"

    override fun widget(): String =
        when (SelenKConfig.automationType) {
            is AutomationType.Web -> WEB
            is AutomationType.XcUiTest -> XCUITEST
            is AutomationType.UiAutomator2 -> UIAUTOMATOR2
        }
}
