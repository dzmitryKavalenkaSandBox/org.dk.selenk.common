package org.dk.selenk.common.widget.mobile.android

import org.dk.selenk.common.AutomationType
import org.dk.selenk.common.widget.BaseWidgetTest
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ListViewTest : BaseWidgetTest(LinearLayout) {

    private fun expectedWidget(): String = LinearLayout.UIAUTOMATOR2

    @ParameterizedTest
    @MethodSource("widgetProvider")
    fun `assert widget resolving`(automationType: AutomationType) {
        automationType.assertWidgetResolving(expectedWidget())
    }
}
