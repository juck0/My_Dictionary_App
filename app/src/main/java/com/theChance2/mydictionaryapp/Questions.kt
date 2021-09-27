package com.theChance2.mydictionaryapp

import com.google.gson.annotations.SerializedName

data class Questions(
    @SerializedName("translatedText")
    val translatedText: String?
)