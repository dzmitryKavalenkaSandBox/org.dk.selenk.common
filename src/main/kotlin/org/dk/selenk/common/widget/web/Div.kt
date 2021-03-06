package org.dk.selenk.common.widget.web

import org.dk.selenk.common.AutomationType
import org.dk.selenk.common.SelenKConfig

object Div : WebWidget {

    override val WEB: String = "div"

    override fun widget(): String =
        when (SelenKConfig.automationType) {
            is AutomationType.Web -> WEB
            else -> throw widgetNoSupportedOnPlatformExceptionProvider()
        }
}
