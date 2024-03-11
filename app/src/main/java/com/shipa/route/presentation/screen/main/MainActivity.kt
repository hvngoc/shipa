package com.shipa.route.presentation.screen.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.shipa.route.R
import com.shipa.route.databinding.ActivityMainBinding
import com.shipa.route.util.replaceFragment
import org.koin.core.component.KoinComponent

class MainActivity : AppCompatActivity(), KoinComponent {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        val fragment = supportFragmentManager.findFragmentByTag(MainFragment.TAG)
        if (fragment == null) {
            replaceFragment(R.id.container, MainFragment.newInstance(), MainFragment.TAG)
        }
    }
}