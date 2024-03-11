package com.shipa.route.presentation.base

import com.airbnb.epoxy.EpoxyModelWithHolder

/**
 * Created by hvngoc on 7/29/22
 */
interface MasterEpoxyBuilder {
    fun buildHolder(): List<EpoxyModelWithHolder<*>>
}