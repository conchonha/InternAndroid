package com.example.learnnavigation.extension

import retrofit2.HttpException
import java.io.IOException


fun traceErrorException(throwable: Throwable?): String {
    return when (throwable) {

        is HttpException -> {
            when (throwable.code()) {
                200->"0k"
                400 -> "BAD_REQUEST"
                401 -> "UNAUTHORIZED"
//                403 -> ApiError(
//                    throwable.message(),
//                    throwable.code(),
//                    ApiError.ErrorStatus.FORBIDDEN
//                )
//
//                404 -> ApiError(
//                    throwable.message(),
//                    throwable.code(),
//                    ApiError.ErrorStatus.NOT_FOUND
//                )
//
//                405 -> ApiError(
//                    throwable.message(),
//                    throwable.code(),
//                    ApiError.ErrorStatus.METHOD_NOT_ALLOWED
//                )
//
//                409 -> ApiError(
//                    throwable.message(),
//                    throwable.code(),
//                    ApiError.ErrorStatus.CONFLICT
//                )
//
//                500 -> ApiError(
//                    throwable.message(),
//                    throwable.code(),
//                    ApiError.ErrorStatus.INTERNAL_SERVER_ERROR
//                )
//
                else -> "UNKNOWN_ERROR"
//                else -> ApiError(
//                    UNKNOWN_ERROR_MESSAGE,
//                    0,
//                    ApiError.ErrorStatus.UNKNOWN_ERROR
//                )
            }
        }
//
//        is SocketTimeoutException -> {
//            ApiError(throwable.message, ApiError.ErrorStatus.TIMEOUT)
//        }
//

        is IOException -> "NO_CONNECTION"

//
//        else -> ApiError(UNKNOWN_ERROR_MESSAGE, 0, ApiError.ErrorStatus.UNKNOWN_ERROR)
                else -> "UNKNOWN_ERROR"
    }
}