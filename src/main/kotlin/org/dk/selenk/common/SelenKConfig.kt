package org.dk.selenk.common

object SelenKConfig {

    lateinit var automationType: AutomationType
    lateinit var platform: Platform

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
