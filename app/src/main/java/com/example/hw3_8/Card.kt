package com.example.hw3_8

import android.widget.ImageView
import java.io.Serializable

data class Card(
    val image: Int,
    val status: String,
    val name: String
): Serializable
