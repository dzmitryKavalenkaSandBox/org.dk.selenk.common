package org.dk.selenk.common

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class AutomationTypeTest {

    companion object {
        @JvmStatic
        fun automationTypeProvider(): Stream<Pair<String, AutomationType>> =
            Stream.of(
                Pair("UiAutomator2", AutomationType.UiAutomator2),
                Pair("uiautomator2", AutomationType.UiAutomator2),
                Pair("XcUiTest", AutomationType.XcUiTest),
                Pair("XCUITest", AutomationType.XcUiTest),
            )
    }

    @ParameterizedTest
    @MethodSource("automationTypeProvider")
    fun `automation type correctly resolved from string`(platformPair: Pair<String, AutomationType>) {
        val (automationTypeString, automationType) = platformPair
        assertThat(AutomationType.fromString(automationTypeString), `is`(automationType))
    }
}