package org.dk.selenk.common.widget.general

import io.mockk.every
import io.mockk.mockk
import org.dk.selenk.common.AutomationType
import org.dk.selenk.common.SelenKConfig
import org.dk.selenk.common.widget.BaseWidgetTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ButtonTest : BaseWidgetTest(Button) {

    private fun expectedWidget(automationType: AutomationType = SelenKConfig.automationType): String =
        when (automationType) {
            is AutomationType.Web -> Button.WEB
            is AutomationType.XcUiTest -> Button.XCUITEST
            is AutomationType.UiAutomator2 -> Button.UIAUTOMATOR2
        }

    @ParameterizedTest
    @MethodSource("widgetProvider")
    fun `assert button widget resolving`(automationType: AutomationType) {
        val config: SelenKConfig = mockk()

        every { config.automationType } returns automationType

        assertThat(widget.widget(), `is`(expectedWidget(automationType)))
    }
}
