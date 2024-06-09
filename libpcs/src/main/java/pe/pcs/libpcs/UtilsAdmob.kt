package pe.pcs.libpcs

import android.content.Context
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

object UtilsAdmob {

    var interstitial: InterstitialAd? = null

    fun initInterstitial(contexto: Context, idAdmobInterstitial: String) {
        InterstitialAd.load(
            contexto,
            idAdmobInterstitial,
            AdRequest.Builder().build(),
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(p0: InterstitialAd) {
                    interstitial = p0
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    interstitial = null
                }
            })
    }

}