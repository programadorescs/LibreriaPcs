package pe.pcs.libpcs

object UtilsString {

    fun padLeftFixedThree(input: String): String {
        return if (input.length < 3) "000".substring(input.length) + input else input
    }

    fun padLeftFixedSeven(input: String): String {
        return if (input.length < 7) "0000000".substring(input.length) + input else input
    }

    fun padLeftFixedEight(input: String): String {
        return if (input.length < 8) "00000000".substring(input.length) + input else input
    }

    fun padLeftFixedNine(input: String): String {
        return if (input.length < 9) "000000000".substring(input.length) + input else input
    }

}