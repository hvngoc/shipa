package com.shipa.route.domain.response

import com.google.gson.annotations.SerializedName

/**
 * Created by hvngoc on 7/29/22
 */
data class CommonError(
    @SerializedName("cod")
    val cod: String?,
    @SerializedName("message")
    val message: String?
)