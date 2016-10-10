package br.com.thiengo.geolocationads;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.inlocomedia.android.ads.AdRequest;
import com.inlocomedia.android.ads.interstitial.InterstitialAd;
import com.inlocomedia.android.ads.interstitial.InterstitialAdListener;

import br.com.thiengo.geolocationads.domain.CountAds;
import br.com.thiengo.geolocationads.domain.Game;

public class GameActivity extends AppCompatActivity {

    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ImageView imgHome = (ImageView) findViewById(R.id.img_home);
        ImageView imgVisitant = (ImageView) findViewById(R.id.img_visitant);
        TextView goalsHome = (TextView) findViewById(R.id.goals_home);
        TextView goalsVisitant = (TextView) findViewById(R.id.goals_visitan);

        if( getIntent() != null
                && getIntent().getParcelableExtra("game") != null ){

            Game game = (Game) getIntent().getParcelableExtra("game");

            imgHome.setImageResource( game.getSoccerTeamHome().getImage() );
            imgVisitant.setImageResource( game.getSoccerTeamVisitant().getImage() );
            goalsHome.setText( String.valueOf( game.getHomeGoals() ) );
            goalsVisitant.setText( String.valueOf( game.getVisitantGoals() ) );

            initAds();
        }
        else{
            finish();
        }
    }


    private void initAds(){
        InterstitialAd iAd = new InterstitialAd(this);
        iAd.setInterstitialAdListener(new InterstitialAdListener(){
            @Override
            public void onAdReady(InterstitialAd ad) {
                super.onAdReady(ad);
                interstitialAd = ad;
            }

            @Override
            public void onAdClosed(InterstitialAd ad) {
                super.onAdClosed(ad);
                finish();
            }
        });

        AdRequest adRequest = new AdRequest();
        adRequest.setAdUnitId( "Ads Unit ID" );

        iAd.loadAd(adRequest);
    }


    @Override
    public void onBackPressed() {
        if( interstitialAd != null
                && CountAds.isUpToShowAd(this) ){

            interstitialAd.show();
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        CountAds.incrementCounter(this);
        super.onDestroy();
    }
}
