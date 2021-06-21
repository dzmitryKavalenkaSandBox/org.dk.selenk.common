package org.dk.selenk.common.widget.ios

import io.mockk.every
import io.mockk.mockk
import org.dk.selenk.common.AutomationType
import org.dk.selenk.common.SelenKConfig
import org.dk.selenk.common.widget.BaseWidgetTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class NavigationBarTest : BaseWidgetTest(NavigationBar) {

    private fun expectedWidget(): String = NavigationBar.XCUITEST

    @ParameterizedTest
    @MethodSource("widgetProvider")
    fun `assert image widget resolving`(automationType: AutomationType) {
        val config: SelenKConfig = mockk()

        every { config.automationType } returns automationType

        assertThat(widget.widget(), `is`(expectedWidget()))
    }
}
