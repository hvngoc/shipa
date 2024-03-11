package com.shipa.route.util

import android.view.View

/**
 * Created by hvngoc on 7/29/22
 */
fun View.visibleIf(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}