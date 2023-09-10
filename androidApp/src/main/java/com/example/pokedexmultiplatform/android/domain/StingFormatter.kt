package com.example.pokedexmultiplatform.android.domain

import java.util.Locale

object StingFormatter {

    fun changeFirstLetterToUppercaseAndDeleteMiddleDash(str: String): String {
        return changeFirstLetterToUppercase(str).replace("-", " ")
    }
    private fun changeFirstLetterToUppercase(str: String): String {
        return str.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
        }
    }
}