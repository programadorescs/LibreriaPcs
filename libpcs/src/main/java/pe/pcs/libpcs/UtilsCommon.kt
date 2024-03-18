package pe.pcs.libpcs

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Switch
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import kotlin.system.exitProcess

object UtilsCommon {

    fun hideKeyboard(context: Context, view: View) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun cleanEditText(view: View) {
        val it: Iterator<View> = view.touchables.iterator()
        while (it.hasNext()) {
            val v = it.next()
            if (v is EditText) v.setText("")
        }
    }

    fun cleanCheckBox(view: View) {
        val it: Iterator<View> = view.touchables.iterator()

        while (it.hasNext()) {
            val v = it.next()
            if (v is CheckBox) v.isChecked = false
        }
    }

    fun cleanEditTextAndCheckBox(view: View) {
        val it: Iterator<View> = view.touchables.iterator()
        while (it.hasNext()) {
            val v = it.next()
            if (v is CheckBox) v.isChecked = false
            if (v is EditText) v.setText("")
        }
    }

    fun cleanEditTextAndSwitch(view: View) {
        val it: Iterator<View> = view.touchables.iterator()
        while (it.hasNext()) {
            val v = it.next()
            if (v is Switch) v.isChecked = false
            if (v is EditText) v.setText("")
        }
    }

    fun formatFromDoubleToString(valor: Double): String {
        val formato = DecimalFormat("#0.00")

        val dfs = DecimalFormatSymbols()
        dfs.decimalSeparator = '.'

        formato.decimalFormatSymbols = dfs

        return formato.format(valor).toString()
    }

    fun closeApp(context: Context) {
        val builder = MaterialAlertDialogBuilder(context)
        builder.setTitle("Confirmacion")
        builder.setMessage("¿Esta seguro de salir de la app?")
        builder.setCancelable(false)
        builder.setPositiveButton("Aceptar") { _: DialogInterface?, _: Int ->
            (context as Activity).finish()
            System.gc()
            exitProcess(0)
        }
        builder.setNegativeButton("Cancelar") { dialog: DialogInterface, _: Int ->
            dialog.cancel()
        }

        builder.create().show()
    }

}