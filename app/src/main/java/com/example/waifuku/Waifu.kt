package com.example.waifuku

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Waifu(
    val name : String,
    val description : String,
    val detail : String,
    val photo : Int,
):Parcelable
