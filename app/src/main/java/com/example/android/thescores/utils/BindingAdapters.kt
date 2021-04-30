package com.example.android.thescores.utils

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.android.thescores.R
import com.example.android.thescores.model.TeamsItem
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou


@BindingAdapter("bind_image")
fun ImageView.bindImageToView(teamsItem: TeamsItem?){
        if (teamsItem?.crestUrl != null){
            GlideToVectorYou
                .init()
                .with(context)
                .setPlaceHolder(R.drawable.loading_animation, R.drawable.ic_broken_image)
                .load(Uri.parse(teamsItem.crestUrl), this)
        }
}