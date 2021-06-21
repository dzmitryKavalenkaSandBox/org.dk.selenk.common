package org.dk.selenk.common.widget.general

import org.dk.selenk.common.AutomationType
import org.dk.selenk.common.SelenKConfig
import org.dk.selenk.common.widget.BaseWidgetTest
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ImageTest : BaseWidgetTest(Image) {

    private fun expectedWidget(automationType: AutomationType = SelenKConfig.automationType): String =
        when (automationType) {
            is AutomationType.Web -> Image.WEB
            is AutomationType.XcUiTest -> Image.XCUITEST
            is AutomationType.UiAutomator2 -> Image.UIAUTOMATOR2
        }

    @ParameterizedTest
    @MethodSource("widgetProvider")
    fun `assert widget resolving`(automationType: AutomationType) {
        automationType.assertWidgetResolving(expectedWidget(automationType))
    }
}
