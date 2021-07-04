package org.dk.selenk.common.util.platfromexec

import org.dk.selenk.common.SelenKConfig

@SelenKBuilderMarker
open class PlatformExecutor<T>: Executor<T> {

    override lateinit var task: () -> T

    fun iOS(task: () -> T) = apply {
        if (SelenKConfig.isIOS()) this.task = task
    }

    fun android(task: () -> T) = apply {
        if (SelenKConfig.isAndroid()) this.task = task
    }
}
