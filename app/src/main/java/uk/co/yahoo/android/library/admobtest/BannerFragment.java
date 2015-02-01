package uk.co.yahoo.android.library.admobtest;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * The Fragment that will contain a Banner
 */
public class BannerFragment extends Fragment {

    /**
     * The Tag for the Log
     */
    private static final String TAG = BannerFragment.class.getSimpleName();

    /**
     * Log implementation for AdListener
     */
    private final AdListener mAdListener = new AdListener() {
        @Override
        public void onAdClosed() {
            Log.d(TAG, "onAdClosed");
        }

        @Override
        public void onAdFailedToLoad(int errorCode) {
            String message = "Unknown";
            switch (errorCode) {
                case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                    message = "ERROR_CODE_INTERNAL_ERROR";
                    break;
                case AdRequest.ERROR_CODE_INVALID_REQUEST:
                    message = "ERROR_CODE_INVALID_REQUEST";
                    break;
                case AdRequest.ERROR_CODE_NETWORK_ERROR:
                    message = "ERROR_CODE_NETWORK_ERROR";
                    break;
                case AdRequest.ERROR_CODE_NO_FILL:
                    message = "ERROR_CODE_NO_FILL";
                    break;
            }
            Log.d(TAG, message);
        }

        @Override
        public void onAdLeftApplication() {
            Log.d(TAG, "onAdLeftApplication");
        }

        @Override
        public void onAdOpened() {
            Log.d(TAG, "onAdOpened");
        }

        @Override
        public void onAdLoaded() {
            Log.d(TAG, "onAdLoaded");
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_banner, container, false);
    }

    @Override
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        AdView mAdView = (AdView) getView().findViewById(R.id.adView);
        mAdView.setAdListener(mAdListener);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

}
