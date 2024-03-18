package pe.pcs.libpcs

import java.util.regex.Pattern

class NumberToLetter {

    private val UNIDADES = arrayOf(
        "",
        "un ",
        "dos ",
        "tres ",
        "cuatro ",
        "cinco ",
        "seis ",
        "siete ",
        "ocho ",
        "nueve "
    )
    private val DECENAS = arrayOf(
        "diez ", "once ", "doce ", "trece ", "catorce ", "quince ", "dieciseis ",
        "diecisiete ", "dieciocho ", "diecinueve", "veinte ", "treinta ", "cuarenta ",
        "cincuenta ", "sesenta ", "setenta ", "ochenta ", "noventa "
    )
    private val CENTENAS = arrayOf(
        "",
        "ciento ",
        "doscientos ",
        "trecientos ",
        "cuatrocientos ",
        "quinientos ",
        "seiscientos ",
        "setecientos ",
        "ochocientos ",
        "novecientos "
    )

    fun Convertir(valor: String, nombreMoneda: String, mayusculas: Boolean): String {
        var numero = valor
        var literal = ""
        val parte_decimal: String
        //si el numero utiliza (.) en lugar de (,) -> se reemplaza
        numero = numero.replace(".", ",")

        //si el numero no tiene parte decimal, se le agrega ,00
        if (numero.indexOf(",") == -1) {
            numero = "$numero,00"
        }

        //se valida formato de entrada -> 0,00 y 999 999 999,00
        return if (Pattern.matches("\\d{1,9},\\d{1,2}", numero)) {
            //se divide el numero 0000000,00 -> entero y decimal
            val Num = numero.split(",".toRegex()).toTypedArray()
            //de da formato al numero decimal
            parte_decimal = "con " + Num[1] + "/100 " + nombreMoneda
            //se convierte el numero a literal
            literal = if (Num[0].toInt() == 0) { //si el valor es cero
                "cero "
            } else if (Num[0].toInt() > 999999) { //si es millon
                getMillones(Num[0])
            } else if (Num[0].toInt() > 999) { //si es miles
                getMiles(Num[0])
            } else if (Num[0].toInt() > 99) { //si es centena
                getCentenas(Num[0])
            } else if (Num[0].toInt() > 9) { //si es decena
                getDecenas(Num[0])
            } else { //sino unidades -> 9
                getUnidades(Num[0])
            }
            //devuelve el resultado en mayusculas o minusculas
            if (mayusculas) {
                (literal + parte_decimal).uppercase().trim { it <= ' ' }
            } else {
                (literal + parte_decimal).trim { it <= ' ' }
            }
        } else { //error, no se puede convertir
            null!!.also { literal = it }
        }
    }

    /* dao para convertir los numeros a literales */
    private fun getUnidades(numero: String): String { // 1 - 9
        //si tuviera algun 0 antes se lo quita -> 09 = 9 o 009=9
        val num = numero.substring(numero.length - 1)
        return UNIDADES[num.toInt()]
    }

    private fun getDecenas(num: String): String { // 99
        val n = num.toInt()
        return if (n < 10) { //para casos como -> 01 - 09
            getUnidades(num)
        } else if (n > 19) { //para 20...99
            val u = getUnidades(num)
            if (u == "") { //para 20,30,40,50,60,70,80,90
                DECENAS[num.substring(0, 1).toInt() + 8]
            } else {
                DECENAS[num.substring(0, 1).toInt() + 8] + "y " + u
            }
        } else { //numeros entre 11 y 19
            DECENAS[n - 10]
        }
    }

    private fun getCentenas(num: String): String { // 999 o 099
        return if (num.toInt() > 99) { //es centena
            if (num.toInt() == 100) { //caso especial
                " cien "
            } else {
                CENTENAS[num.substring(0, 1).toInt()] + getDecenas(num.substring(1))
            }
        } else { //por Ej. 099
            //se quita el 0 antes de convertir a decenas
            getDecenas(num.toInt().toString() + "")
        }
    }

    private fun getMiles(numero: String): String { // 999 999
        //obtiene las centenas
        val c = numero.substring(numero.length - 3)
        //obtiene los miles
        val m = numero.substring(0, numero.length - 3)
        var n = ""
        //se comprueba que miles tenga valor entero
        return if (m.toInt() > 0) {
            n = getCentenas(m)
            n + "mil " + getCentenas(c)
        } else {
            "" + getCentenas(c)
        }
    }

    private fun getMillones(numero: String): String { //000 000 000
        //se obtiene los miles
        val miles = numero.substring(numero.length - 6)
        //se obtiene los millones
        val millon = numero.substring(0, numero.length - 6)
        var n = ""
        n = if (millon.length > 1) {
            getCentenas(millon) + "millones "
        } else {
            getUnidades(millon) + "millon "
        }
        return n + getMiles(miles)
    }

}