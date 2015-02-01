package uk.co.yahoo.android.library.admobtest;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


/**
 * The Activity we use to test Interstitial
 */
public class InterstitialActivity extends ActionBarActivity {

    /**
     * The Interstitial Ad
     */
    private InterstitialAd mInterstitialAd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interstitial);

        // We create the instance for the InterstitialAd
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));

        // We create the request for the banner
        AdRequest adRequest = new AdRequest.Builder().build();

        // Begin loading your interstitial.
        mInterstitialAd.loadAd(adRequest);

    }


    /**
     * Invoked when we select the button for Interstitial
     *
     * @param button The Interstitial button
     */
    public void showInterstitial(View button) {
        // We show the Interstitial if it's ready
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

}
