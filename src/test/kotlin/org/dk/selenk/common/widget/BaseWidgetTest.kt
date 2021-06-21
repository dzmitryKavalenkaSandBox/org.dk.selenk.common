package org.dk.selenk.common.widget

import org.dk.selenk.common.AutomationType
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
    }

}
