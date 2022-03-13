package org.dk.selenk.common

import org.dk.selenk.common.exception.ErrorCodeDefinition
import org.dk.selenk.common.exception.SelenKException
import java.net.URL
import java.util.concurrent.ConcurrentHashMap

object SelenKConfig {

    lateinit var automationType: AutomationType
    lateinit var platform: Platform

    // mobile
    private var appiumUrl: MutableMap<Long, URL> = ConcurrentHashMap()
    var enableAppiumLogs: Boolean = false

    fun getAppiumUrl(): URL =
        appiumUrl[Thread.currentThread().id] ?: throw SelenKException("Appium Url was not set; " +
            "Check if appium local service was started or if it was not - setAppiumUrl(String) function was called upon driver preparation preparation",
            ErrorCodeDefinition.APPIUM_URL_NOT_PROVIDED)

    fun setAppiumUrl(url: String) {
        appiumUrl[Thread.currentThread().id] = URL(url)
    }

    fun isWeb() = platform == Platform.Web
    fun isIPhone() = platform == Platform.iPhone
    fun isIPad() = platform == Platform.iPad
    fun isAndroidSmart() = platform == Platform.AndroidSmart
    fun isAndroidTab() = platform == Platform.AndroidTab
    fun isIOS() = isIPhone() || isIPad()
    fun isAndroid() = isAndroidSmart() || isAndroidTab()
    fun isSmartphone() = isAndroidSmart() || isIPhone()
    fun isTablet() = isAndroidTab() || isIPad()
}
