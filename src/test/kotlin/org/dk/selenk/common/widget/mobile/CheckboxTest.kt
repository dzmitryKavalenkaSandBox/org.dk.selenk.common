package org.dk.selenk.common.widget.mobile

import org.dk.selenk.common.AutomationType
import org.dk.selenk.common.SelenKConfig
import org.dk.selenk.common.widget.BaseWidgetTest
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class CheckboxTest : BaseWidgetTest(Checkbox) {

    private fun expectedWidget(automationType: AutomationType = SelenKConfig.automationType): String =
        when (automationType) {
            is AutomationType.XcUiTest -> Checkbox.XCUITEST
            is AutomationType.UiAutomator2 -> Checkbox.UIAUTOMATOR2
            else -> ""
        }

    @ParameterizedTest
    @MethodSource("widgetProvider")
    fun `assert widget resolving`(automationType: AutomationType) {
        automationType.assertWidgetResolving(expectedWidget(automationType))
    }
}
