package com.example.kiwiflights.util

import android.widget.ImageView
import com.squareup.picasso.Picasso

object ImageLoader {

    /**
     * Method to load an image to a view from a url using [Picasso]
     * @param imageUrl
     * @param imageView
     */
    fun displayImage(imageUrl: String?, imageView: ImageView) {
        Picasso.get().load(imageUrl).fit().into(imageView)
    }
}