package pe.pcs.libpcs

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Matrix
import android.util.Base64
import android.view.View
import java.io.ByteArrayOutputStream

object UtilsImage {

    /**
     * Convierte un arreglo de bytes a un objeto Bitmap.
     *
     * Esta función toma un arreglo de bytes que representan una imagen y lo convierte a un objeto
     * Bitmap para su posterior manipulación o visualización.
     *
     * @param imageByte El arreglo de bytes que representa la imagen.
     * @return El objeto Bitmap de la imagen.
     * @throws IllegalArgumentException Si el arreglo de bytes no es válido.
     * @author Jack Chavez Saravia
     */
    fun convertByteToImage(imageByte: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(imageByte, 0, imageByte.size)
    }

    /**
     * Codifica una imagen en formato Bitmap a una cadena Base64.
     *
     * Esta función convierte una imagen representada por un objeto Bitmap a una cadena Base64.
     * La cadena Base64 permite almacenar o transmitir la imagen de forma eficiente.
     *
     * @param image La imagen en formato Bitmap a codificar.
     * @return La cadena Base64 representando la imagen.
     * @author Jack Chavez Saravia
     */
    fun encodeToBase64(image: Bitmap): String {
        val baos = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.PNG, 100, baos)
        return Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT).trim()
    }

    /**
     * Decodifica una cadena Base64 a un objeto Bitmap.
     *
     * Esta función toma una cadena Base64 que representa una imagen codificada y la decodifica
     * a un objeto Bitmap para su posterior manipulación o visualización.
     *
     * @param input La cadena Base64 que representa la imagen.
     * @return El objeto Bitmap de la imagen decodificada.
     * @throws IllegalArgumentException Si la cadena Base64 no es válida.
     * @author Jack Chavez Saravia
     */
    fun decodeBase64(input: String?): Bitmap {
        val decodedByte = Base64.decode(input, 0)
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.size)
    }

    /**
     * Obtiene una captura de imagen (Bitmap) de una vista.
     *
     * Esta función captura una imagen (Bitmap) del contenido de una vista, incluyendo todos sus hijos.
     * La imagen capturada tiene el mismo tamaño que la vista.
     *
     * @param view La vista o imageview de la cual se desea obtener la captura.
     * @return El objeto Bitmap representando la captura de la vista.
     * @author Jack Chavez Saravia
     */
    fun getBitmapFromView(view: View): Bitmap {
        val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        view.draw(Canvas(bitmap))
        return bitmap
    }

    /**
     * Redimensiona una imagen (Bitmap) a un nuevo ancho y alto.
     *
     * Esta función toma un objeto Bitmap y lo redimensiona a un nuevo ancho y alto especificados.
     *
     * @param mBitmap El objeto Bitmap de la imagen a redimensionar.
     * @param newWidth El nuevo ancho deseado para la imagen.
     * @param newHeigth El nuevo alto deseado para la imagen.
     * @return El objeto Bitmap de la imagen redimensionada.
     * @author Jack Chavez Saravia
     */
    fun resizeImage(mBitmap: Bitmap, newWidth: Float, newHeigth: Float): Bitmap {
        //Redimensionamos
        val width = mBitmap.width
        val height = mBitmap.height

        val scaleWidth = newWidth / width
        val scaleHeight = newHeigth / height

        // create a matrix for the manipulation
        val matrix = Matrix()
        // resize the bit map
        matrix.postScale(scaleWidth, scaleHeight)
        // recreate the new Bitmap
        return Bitmap.createBitmap(mBitmap, 0, 0, width, height, matrix, false)
    }

}