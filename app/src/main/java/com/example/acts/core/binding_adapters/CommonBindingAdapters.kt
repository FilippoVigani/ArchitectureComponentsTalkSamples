package com.example.acts.core.binding_adapters

import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

@BindingMethods(
    BindingMethod(
        type = SwipeRefreshLayout::class,
        attribute = "app:isRefreshing",
        method = "setRefreshing"
    )
)
object BindingMethods