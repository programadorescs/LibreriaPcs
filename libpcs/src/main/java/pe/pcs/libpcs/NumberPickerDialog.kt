package pe.pcs.libpcs

import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.NumberPicker
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.util.Calendar

class NumberPickerDialog : DialogFragment() {

    private lateinit var etDato: EditText
    private lateinit var mTitle: String

    companion object {
        fun newInstance(txtAnio: EditText, title: String): NumberPickerDialog {
            val fragment = NumberPickerDialog()
            fragment.mTitle = title
            fragment.etDato = txtAnio
            fragment.isCancelable = false
            return fragment
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val numberPicker = NumberPicker(requireContext()).apply {
            descendantFocusability = ViewGroup.FOCUS_BLOCK_DESCENDANTS
            maxValue = 3000
            minValue = 1990
            value = Calendar.getInstance()[Calendar.YEAR]
            wrapSelectorWheel = false
        }

        // Para autoajustar al contenido y centrar el numberPicker
        val vista = FrameLayout(requireContext()).apply {
            addView(
                numberPicker, FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT,
                    Gravity.CENTER
                )
            )
        }

        return MaterialAlertDialogBuilder(requireContext()).apply {
            setTitle(mTitle)
            setView(vista)
            setPositiveButton("Aceptar") { _, _ ->
                etDato.setText(String.format("%04d", numberPicker.value))
            }
            setNegativeButton("Cancelar") { dialog, _ ->
                dialog.cancel()
            }
        }.create()
    }

}