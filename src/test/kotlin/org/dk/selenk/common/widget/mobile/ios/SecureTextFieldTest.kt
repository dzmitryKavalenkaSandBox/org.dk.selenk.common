package org.dk.selenk.common.widget.mobile.ios

import org.dk.selenk.common.AutomationType
import org.dk.selenk.common.widget.BaseWidgetTest
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class SecureTextFieldTest : BaseWidgetTest(SecureTextField) {

    private fun expectedWidget(): String = SecureTextField.XCUITEST

    @ParameterizedTest
    @MethodSource("widgetProvider")
    fun `assert widget resolving`(automationType: AutomationType) {
        automationType.assertWidgetResolving(expectedWidget())
    }
}
