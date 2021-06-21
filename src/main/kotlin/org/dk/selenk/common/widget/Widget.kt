package org.dk.selenk.common.widget

import org.dk.selenk.common.SelenKConfig
import org.dk.selenk.common.exception.ErrorCodeDefinition
import org.dk.selenk.common.exception.SelenKException

@Suppress("PropertyName")
interface Widget {

    fun widgetNoSupportedOnPlatformExceptionProvider(): Throwable =
        SelenKException(
            "'${this::class.java.simpleName}' widget is not supported on '${SelenKConfig.automationType.type}' platform",
            ErrorCodeDefinition.NOT_SUPPORTED_ON_PLATFORM
        )

    fun widget(): String
}
