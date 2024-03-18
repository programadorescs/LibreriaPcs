package pe.pcs.libpcs

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Matrix
import android.util.Base64
import android.view.View
import java.io.ByteArrayOutputStream

object UtilsImage {

    fun convertByteToImage(imageByte: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(imageByte, 0, imageByte.size)
    }

    fun encodeToBase64(image: Bitmap): String {
        val baos = ByteArrayOutputStream()
        image.compress(Bitmap.CompressFormat.PNG, 100, baos)
        return Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT).trim()
    }

    fun decodeBase64(input: String?): Bitmap {
        val decodedByte = Base64.decode(input, 0)
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.size)
    }

    // Obtiene la imagen de una vista o ImageView
    fun getBitmapFromView(view: View): Bitmap {
        val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        view.draw(Canvas(bitmap))
        return bitmap
    }

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