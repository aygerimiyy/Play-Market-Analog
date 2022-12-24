package com.example.rvinrv

import androidx.annotation.DrawableRes

data class Add(
    @DrawableRes val image: Int,
    val imageMidle: Int,
    var num: Int,
    var name: String,
    var description: String
)
