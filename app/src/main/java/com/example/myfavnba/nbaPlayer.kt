package com.example.myfavnba

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class nbaPlayer(
    val name: String,
    val tim: String,
    val photo: Int,
    val kelahiran: String,
    val no_punggung: String,
    val tinggi: String,
    val status: String,
    val description: String
) : Parcelable
/**/