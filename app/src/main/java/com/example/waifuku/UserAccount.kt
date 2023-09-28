package com.example.waifuku

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserAccount(
    val name : String,
    val email : String,
):Parcelable
