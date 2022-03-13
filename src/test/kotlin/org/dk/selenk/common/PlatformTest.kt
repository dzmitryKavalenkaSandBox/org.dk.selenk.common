package org.dk.selenk.common

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class PlatformTest {

    companion object {
        @JvmStatic
        fun platformProvider(): Stream<Pair<String, Platform>> =
            Stream.of(
                Pair("AndroidSmart", Platform.AndroidSmart),
                Pair("AndroidSmartphone", Platform.AndroidSmart),
                Pair("AndroidTab", Platform.AndroidTab),
                Pair("AndroidTablet", Platform.AndroidTab),
                Pair("iPad", Platform.iPad),
                Pair("iPhone", Platform.iPhone),
            )
    }

    @ParameterizedTest
    @MethodSource("platformProvider")
    fun `platform correctly resolved from string`(platformPair: Pair<String, Platform>) {
        val (platformString, platform) = platformPair
        assertThat(Platform.fromString(platformString), `is`(platform))
    }
}