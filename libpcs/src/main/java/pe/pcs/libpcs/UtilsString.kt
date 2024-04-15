package pe.pcs.libpcs

object UtilsString {

    /**
     * Esta función agrega ceros a la izquierda de una cadena para que tenga una longitud fija de 3 caracteres.
     * @param input La cadena a la que se le agregarán ceros.
     * @return La cadena original con ceros agregados a la izquierda si es necesario, o la cadena original si ya tiene 3 caracteres o más.
     * Ejemplos:
     * padLeftFixedThree("1") // Devuelve "001"
     * padLeftFixedThree("123") // Devuelve "123"
     * @author Jack Chavez Saravia
     */
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

    /**
     * Agrega ceros a la izquierda de una cadena.
     *
     * Esta función agrega ceros a la cadena de entrada para asegurarse de que alcance la longitud especificada.
     * Si la longitud de la cadena de entrada ya es mayor o igual a la longitud especificada,
     * no se realiza ningún relleno.
     * NOTA: La cantidad de caracteres de input no puede ser mayor que de numberOfZeros.
     *
     * @param input La cadena de entrada a la que se agregarán los ceros.
     * @param numberOfZeros La longitud deseada de la cadena resultante, incluyendo los ceros.
     * @return La cadena de entrada con ceros agregados a la izquierda si es necesario.
     * @author Jack Chavez Saravia
     */
    fun padLeftWithZero(input: String, numberOfZeros: Int): String {
        if (input.trim().length > numberOfZeros)
            return input.trim()

        // Calcula la cantidad de ceros necesarios
        val ceros = "0".repeat(numberOfZeros - input.trim().length)
        // Agrega los ceros si es necesario
        return if (input.trim().length < numberOfZeros) ceros + input.trim() else input.trim()
    }

}