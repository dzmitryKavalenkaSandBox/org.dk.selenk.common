package org.dk.selenk.common.util

import io.mockk.every
import io.mockk.mockk
import org.dk.selenk.common.Platform
import org.dk.selenk.common.SelenKConfig
import org.dk.selenk.common.util.platfromexec.Executor.Companion.onDevice
import org.dk.selenk.common.util.platfromexec.Executor.Companion.onPlatform
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class PlatformExecutorTest {

    companion object {
        @JvmStatic
        fun platformProvider(): Stream<Pair<Platform, String>> {
            return Stream.of(
                Platform.AndroidSmart to "Platform.AndroidSmart",
                Platform.AndroidTab to "Platform.AndroidTab",
                Platform.iPhone to "Platform.iPhone",
                Platform.iPad to "Platform.iPad",
            )
        }
    }

    @Test
    fun `if value is not assigned it is allowed to not to specify current platform branch`() {
        val config: SelenKConfig = mockk()

        every { config.platform } returns Platform.iPhone

        onPlatform<String> {
            android { "androidString" }
        }
    }

    @ParameterizedTest
    @MethodSource("platformProvider")
    fun `correct value assigned on appropriate platform and device type`(data: Pair<Platform, String>) {
        val (platform, expectedString) = data
        val config: SelenKConfig = mockk()

        every { config.platform } returns platform

        val result = onPlatform<String> {
            iOS {
                onDevice {
                    tablet { expectedString }
                    smartphone { expectedString }
                }
            }
            android {
                onDevice {
                    tablet { expectedString }
                    smartphone { expectedString }
                }
            }
        }
        assertThat(result, `is`(expectedString))
    }

    @ParameterizedTest
    @MethodSource("platformProvider")
    fun `correct value assigned on appropriate device type`(data: Pair<Platform, String>) {
        val (platform, expectedString) = data
        val config: SelenKConfig = mockk()

        every { config.platform } returns platform

        val result = onDevice<String> {
            tablet { expectedString }
            smartphone { expectedString }
        }
        assertThat(result, `is`(expectedString))
    }

    @ParameterizedTest
    @MethodSource("platformProvider")
    fun `correct value assigned on appropriate platform`(data: Pair<Platform, String>) {
        val (platform, expectedString) = data
        val config: SelenKConfig = mockk()

        every { config.platform } returns platform

        val result = onPlatform<String> {
            iOS { expectedString }
            android { expectedString }
        }
        assertThat(result, `is`(expectedString))
    }
}
