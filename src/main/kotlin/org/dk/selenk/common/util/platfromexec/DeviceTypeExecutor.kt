package org.dk.selenk.common.util.platfromexec

import org.dk.selenk.common.SelenKConfig

@SelenKBuilderMarker
class DeviceTypeExecutor<T> : Executor<T> {

    override lateinit var task: () -> T

    fun smartphone(task: () -> T) = apply {
        if (SelenKConfig.isSmartphone()) this.task = task
    }

    fun tablet(task: () -> T) = apply {
        if (SelenKConfig.isTablet()) this.task = task
    }
}
