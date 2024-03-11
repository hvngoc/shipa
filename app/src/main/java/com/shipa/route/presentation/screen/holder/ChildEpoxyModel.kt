package com.shipa.route.presentation.screen.holder

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.shipa.route.R
import com.shipa.route.databinding.ItemChildBinding

/**
 * Created by hvngoc on 7/29/22
 */

@EpoxyModelClass
abstract class ChildEpoxyModel :
    EpoxyModelWithHolder<ChildEpoxyModel.ChildHolder>() {

    @EpoxyAttribute
    var title: String? = null

    @EpoxyAttribute
    var lat: String? = null

    @EpoxyAttribute
    var lon: String? = null

    override fun getDefaultLayout(): Int {
        return R.layout.item_child
    }

    override fun bind(holder: ChildHolder) {
        holder.binding.title.text = title
        holder.binding.lat.text = lat
        holder.binding.lon.text = lon
    }

    class ChildHolder : EpoxyHolder() {

        lateinit var binding: ItemChildBinding

        override fun bindView(itemView: View) {
            binding = ItemChildBinding.bind(itemView)
        }
    }
}