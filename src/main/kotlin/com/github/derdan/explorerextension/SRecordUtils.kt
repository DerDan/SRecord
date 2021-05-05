package com.github.derdan.explorerextension

import com.github.derdan.explorerextension.psi.SRecordData_

object SRecordUtils {

    private const val NUMBER_OF_REQUIRED_ASCII_CHARS = 2
    private const val FIRST_PRINTABLE_CHAR = 0x20
    private const val HEX_RADIX = 16
    private const val LAST_PRINTABLE_CHAR = 0x7e

    fun getAsciiText(element: SRecordData_): String {
        var asciiHint = ""
        element.byte_List.forEach(action = { asciiHint += getAscii(it.text) })
        return asciiHint;
    }

    private fun getAscii(text: String): String {
        var result = "?"
        if (text.length == NUMBER_OF_REQUIRED_ASCII_CHARS) {
            val hex = Integer.parseInt(text, HEX_RADIX)
            result = when {
                (hex >= FIRST_PRINTABLE_CHAR) && (hex <= LAST_PRINTABLE_CHAR) -> hex.toChar()
                    .toString()
                else -> "."
            }
        }
        return result
    }
}