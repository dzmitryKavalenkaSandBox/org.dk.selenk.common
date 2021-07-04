package org.dk.selenk.common.widget

import io.mockk.every
import io.mockk.mockk
import org.dk.selenk.common.AutomationType
import org.dk.selenk.common.SelenKConfig
import org.dk.selenk.common.exception.SelenKException
import org.dk.selenk.common.widget.mobile.android.UiAutomator2Widget
import org.dk.selenk.common.widget.mobile.ios.XcUiWidget
import org.dk.selenk.common.widget.web.WebWidget
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.assertThrows
import java.util.stream.Stream

abstract class BaseWidgetTest(val widget: Widget) {

    companion object {
        @JvmStatic
        fun widgetProvider(): Stream<AutomationType> {
            return Stream.of(
                AutomationType.XcUiTest,
                AutomationType.UiAutomator2,
                AutomationType.Web,
            )
        }

        fun Widget.isSupported() =
            when (SelenKConfig.automationType) {
                AutomationType.Web -> this is WebWidget
                AutomationType.XcUiTest -> this is XcUiWidget
                AutomationType.UiAutomator2 -> this is UiAutomator2Widget
            }
    }

    fun AutomationType.assertWidgetResolving(expectedWidget: String) {
        val config: SelenKConfig = mockk()

        every { config.automationType } returns this

        if (widget.isSupported()) {
            assertThat(widget.widget(), CoreMatchers.`is`(expectedWidget))
        } else {
            assertThat(assertThrows<SelenKException> { widget.widget() }.message,
                CoreMatchers.`is`("'${widget::class.java.simpleName}' widget is not supported on '${SelenKConfig.automationType.type}' platform"))
        }
    }
}
