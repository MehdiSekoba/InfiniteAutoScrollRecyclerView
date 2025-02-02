package ir.mehdisekoba.sample.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

fun ImageView.loadImage(url: String) {
    Glide.with(this) // Use the ImageView's context directly
        .load(url)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}