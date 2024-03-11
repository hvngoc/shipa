package com.shipa.route.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * Created by hvngoc on 7/29/22
 */

fun AppCompatActivity.replaceFragment(viewId: Int, fragment: Fragment, tag: String) {
    val manager = supportFragmentManager.beginTransaction()
    manager.replace(viewId, fragment, tag)
    manager.commit()
}