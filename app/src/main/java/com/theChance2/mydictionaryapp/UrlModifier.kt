package com.theChance2.mydictionaryapp

object UrlModifier {
    private var myUrl: String = ""
    val url: String
        get() = myUrl


    fun getUrl(text: String?,langSource: String?,langTarget: String?){
        myUrl = "https://translate.astian.org/translate?" +
                "q=${text}" +
                "&source=${langSource}" +
                "&target=${langTarget}" +
                "&format=text"
    }
}
