package com.shipa.route.domain.error

import com.shipa.route.domain.response.CommonError

/**
 * Created by hvngoc on 7/29/22
 */
class MasterThrowable(error: CommonError) : Throwable(message = error.message) {
}