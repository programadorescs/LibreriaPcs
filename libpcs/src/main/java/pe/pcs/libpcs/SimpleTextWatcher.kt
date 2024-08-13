package pe.pcs.libpcs

import android.text.Editable
import android.text.TextWatcher

/**
 * SimpleTextWatcher es una clase abierta que implementa la interfaz TextWatcher con métodos vacíos,
 * lo que permite a los desarrolladores sobrescribir solo los métodos que necesitan.
 *
 * Esta clase es útil para evitar tener que implementar los tres métodos (beforeTextChanged, onTextChanged, afterTextChanged) de TextWatcher cuando
 * solo se requiere uno de ellos.
 *
 * @author Jack Chavez Saravia
 */
open class SimpleTextWatcher : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    override fun afterTextChanged(s: Editable?) {}
}