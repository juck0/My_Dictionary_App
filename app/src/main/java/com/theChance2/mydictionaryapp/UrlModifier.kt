package com.theChance2.mydictionaryapp

object UrlModifier {
    private var myUrl: String = ""

    private val list = listOf(
        "en", "ar", "fr", "es", "cz", "de", "hi", "id", "ir","it", "ja", "ko", "pl", "pt", "ru","tr", "vi",
    )
    val languageList : List<String>
        get() = list




    private val listOfFlags = listOf(
        1,2 , 3, 4, 5, 6, 7, 8,9,10,11, 12,13,14,15,16,17,
    )

    val flagList : List<Int>
        get() = listOfFlags
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
