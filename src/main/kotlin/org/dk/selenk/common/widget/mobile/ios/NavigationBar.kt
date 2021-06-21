package org.dk.selenk.common.widget.mobile.ios

import org.dk.selenk.common.AutomationType
import org.dk.selenk.common.SelenKConfig

object NavigationBar : XcUiWidget {

    override val XCUITEST: String = "XCUIElementTypeNavigationBar"

    override fun widget(): String =
        when (SelenKConfig.automationType) {
            is AutomationType.XcUiTest -> XCUITEST
            else -> throw widgetNoSupportedOnPlatformExceptionProvider()
        }
}
