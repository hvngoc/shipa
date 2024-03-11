package com.shipa.route.presentation.base

import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.shipa.route.R
import org.koin.core.component.KoinComponent

/**
 * Created by hvngoc on 8/22/22
 */
abstract class FullWindowDialogFragment : DialogFragment(), KoinComponent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialog)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }
}