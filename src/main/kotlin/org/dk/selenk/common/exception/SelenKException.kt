package org.dk.selenk.common.exception

import java.lang.RuntimeException

class SelenKException : RuntimeException {

    var errorCode = ErrorCodeDefinition.UNKNOWN_ERROR

    constructor(message: String, errorCode: ErrorCodeDefinition) : super(message) {
        this.errorCode = errorCode
    }

    constructor(message: String, errorCode: ErrorCodeDefinition, cause: Throwable) : super(message, cause) {
        this.errorCode = errorCode
    }

    constructor(errorCode: ErrorCodeDefinition) : super() {
        this.errorCode = errorCode
    }
}
