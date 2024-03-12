package com.shipa.route.presentation.screen.router

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.shipa.route.R
import com.shipa.route.databinding.FragmentRouterBinding
import com.shipa.route.domain.model.RealPoint
import com.shipa.route.domain.response.DataResult
import com.shipa.route.presentation.base.FullWindowDialogFragment
import com.shipa.route.presentation.base.MasterController
import com.shipa.route.presentation.base.MasterEpoxyBuilder
import com.shipa.route.presentation.screen.holder.ChildEpoxyModel_
import com.shipa.route.util.visibleIf
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

/**
 * Created by hvngoc on 7/29/22
 */
class RouterFragment : FullWindowDialogFragment(), KoinComponent, MasterEpoxyBuilder {
    companion object {
        const val TAG = "FragmentRouter"
    }

    private val controller = MasterController(this)
    private val routerViewModel: RouterViewModel by viewModel()
    private lateinit var binding: FragmentRouterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_router, container, false)

        showContent(empty = true)
        binding.recyclerView.setController(controller)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                LinearLayout.VERTICAL
            )
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        routerViewModel.loadData()
        routerViewModel.data.observe(viewLifecycleOwner) {
            when (it) {
                is DataResult.Success<*> -> {
                    showContent(content = true)
                    controller.requestModelBuild()
                }

                is DataResult.Error -> {
                    showContent(error = true)
                    binding.error.text = it.e.message ?: getString(R.string.error_default)
                }
                is DataResult.Loading -> {
                    showContent(loading = true)
                }
            }
        }
    }

    private fun showContent(
        content: Boolean = false,
        error: Boolean = false,
        empty: Boolean = false,
        loading: Boolean = false
    ) {
        binding.recyclerView.visibleIf(content)
        binding.error.visibleIf(error)
        binding.noResult.visibleIf(empty)
        binding.loading.visibleIf(loading)

    }

    override fun buildHolder(): List<EpoxyModelWithHolder<*>> {
        val data = routerViewModel.data.value as? DataResult.Success<*> ?: return emptyList()
        val list = data.data as? List<RealPoint> ?: return emptyList()
        return list.mapIndexed { index, point ->
            val generateId = "$index${point.name}"
            return@mapIndexed ChildEpoxyModel_().id(generateId)
                .title(point.name)
                .lat(point.lat.toString())
                .lon(point.lon.toString())

        }
    }
}