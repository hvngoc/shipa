package com.shipa.route.presentation.base

import com.airbnb.epoxy.EpoxyController

/**
 * Created by hvngoc on 7/29/22
 */
class MasterController(private val builder: MasterEpoxyBuilder) : EpoxyController() {

    private val mutexBuilder = Any()

    override fun buildModels() {
        synchronized(mutexBuilder) {
            val models = builder.buildHolder()
            add(models)
        }
    }
}