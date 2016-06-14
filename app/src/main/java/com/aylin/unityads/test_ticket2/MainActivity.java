package com.aylin.unityads.test_ticket2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.unity3d.ads.android.UnityAds;
import com.unity3d.ads.android.IUnityAdsListener;

public class MainActivity extends AppCompatActivity implements IUnityAdsListener{


    private Button NextButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.i("UnityAds", "UnityAdsTestStartActivity->onCreate()");


        UnityAds.init((Activity) this, "117411", (IUnityAdsListener) this);

        UnityAds.setDebugMode(true);
        UnityAds.setTestMode(true);
        UnityAds.setListener(this);

        setContentView(R.layout.activity_main);
        NextButton = (Button)findViewById(R.id.nextButton);
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(UnityAds.setZone("rewardedVideoZone") && UnityAds.canShow())
                {
                    UnityAds.show();

                }
            }
        });



    }

    @Override
    public void onResume () {
        Log.i("UnityAds", "UnityAdsTestStartActivity->onResume()");

        super.onResume();
        UnityAds.changeActivity(this);
        UnityAds.setListener(this);
    }

    @Override
    public void onHide() {
        // TODO Auto-generated method stub
        Log.i("UnityAds", "UnityAdsTestStartActivity->onHide()");

    }

    @Override
    public void onShow() {

        // TODO Auto-generated method stub
        Log.i("UnityAds", "UnityAdsTestStartActivity->onShow()");
    }

    @Override
    public void onVideoStarted() {
        // TODO Auto-generated method stub
        Log.i("UnityAds", "UnityAdsTestStartActivity->onVideoStarted()");

    }

    @Override
    public void onVideoCompleted(String s, boolean b) {
        // TODO Auto-generated method stub
        //String strReward = UnityAds.getCurrentRewardItemKey(); this api is no longer in use. you don't need to use it.
        Log.i("UnityAds", "UnityAdsTestStartActivity->onVideoCompleted()");

    }

    @Override
    public void onFetchCompleted() {
        // TODO Auto-generated method stub
        Log.i("UnityAds", "UnityAdsTestStartActivity->onFetchCompleted()");

    }

    @Override
    public void onFetchFailed() {
        // TODO Auto-generated method stub
        Log.i("UnityAds", "UnityAdsTestStartActivity->onFetchFailed()");

    }
}
