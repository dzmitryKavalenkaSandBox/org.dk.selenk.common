package org.dk.selenk.common.util.platfromexec

interface Executor<T> {

    val task: () -> T

    companion object {

        inline fun <reified T> onPlatform(performTask: PlatformExecutor<T>.() -> Unit): T {
            val executor = PlatformExecutor<T>()
            executor.performTask()
            return executor.execute()
        }

        inline fun <T> onDevice(performTask: DeviceTypeExecutor<T>.() -> Unit): T {
            val builder = DeviceTypeExecutor<T>()
            builder.performTask()
            return builder.execute()
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun execute(): T = try {
        task()
    } catch (exc: UninitializedPropertyAccessException) {
        Unit as T
    }
}
