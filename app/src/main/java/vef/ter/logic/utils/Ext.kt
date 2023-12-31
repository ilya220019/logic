package vef.ter.logic.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import vef.ter.logic.R


fun ImageView.loadImage(url: String?) {
    Glide.with(this).load(url).placeholder(R.mipmap.ic_launcher).into(this)
}