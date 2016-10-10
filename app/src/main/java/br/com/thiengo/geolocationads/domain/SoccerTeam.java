package br.com.thiengo.geolocationads.domain;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by viniciusthiengo on 10/9/16.
 */

public class SoccerTeam implements Parcelable {
    private int image;
    private String name;

    public SoccerTeam( int image, String name ){
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.image);
        dest.writeString(this.name);
    }

    protected SoccerTeam(Parcel in) {
        this.image = in.readInt();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<SoccerTeam> CREATOR = new Parcelable.Creator<SoccerTeam>() {
        @Override
        public SoccerTeam createFromParcel(Parcel source) {
            return new SoccerTeam(source);
        }

        @Override
        public SoccerTeam[] newArray(int size) {
            return new SoccerTeam[size];
        }
    };
}
