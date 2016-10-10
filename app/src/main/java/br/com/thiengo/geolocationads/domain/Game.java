package br.com.thiengo.geolocationads.domain;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by viniciusthiengo on 10/9/16.
 */

public class Game implements Parcelable {
    private SoccerTeam soccerTeamHome;
    private SoccerTeam soccerTeamVisitant;
    private int homeGoals;
    private int visitantGoals;


    public Game( SoccerTeam soccerTeamHome,
                 SoccerTeam soccerTeamVisitant,
                 int homeGoals,
                 int visitantGoals ){
        this.soccerTeamHome = soccerTeamHome;
        this.soccerTeamVisitant = soccerTeamVisitant;
        this.homeGoals = homeGoals;
        this.visitantGoals = visitantGoals;
    }

    public SoccerTeam getSoccerTeamHome() {
        return soccerTeamHome;
    }

    public SoccerTeam getSoccerTeamVisitant() {
        return soccerTeamVisitant;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public int getVisitantGoals() {
        return visitantGoals;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.soccerTeamHome, flags);
        dest.writeParcelable(this.soccerTeamVisitant, flags);
        dest.writeInt(this.homeGoals);
        dest.writeInt(this.visitantGoals);
    }

    protected Game(Parcel in) {
        this.soccerTeamHome = in.readParcelable(SoccerTeam.class.getClassLoader());
        this.soccerTeamVisitant = in.readParcelable(SoccerTeam.class.getClassLoader());
        this.homeGoals = in.readInt();
        this.visitantGoals = in.readInt();
    }

    public static final Parcelable.Creator<Game> CREATOR = new Parcelable.Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel source) {
            return new Game(source);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };
}
