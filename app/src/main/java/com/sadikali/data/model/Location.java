package com.sadikali.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sadikali1up on 2016-04-26.
 */
public class Location implements Parcelable {
    public String street;
    public String city;
    public String state;
    public String postcode;

    public Location (String street, String city, String state, String postcode){
        this.street = street;
        this.city = city;
        this.state = state;
        this.postcode = postcode;
    }

    public Location (Parcel in)
    {
        this.street = in.readString();
        this.city = in.readString();
        this.state = in.readString();
        this.postcode = in.readString();
    }

    public static final Parcelable.Creator<Location> CREATOR= new Parcelable.Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel source) {
            return new Location(source);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[0];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(street);
        dest.writeString(city);
        dest.writeString(state);
        dest.writeString(postcode);
    }

}

