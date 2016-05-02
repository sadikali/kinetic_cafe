package com.sadikali.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sadikali1up on 2016-04-26.
 */
public class Picture implements Parcelable{
    public String large;
    public String medium;
    public String thumbnail;

    public Picture(String large, String medium, String thumbnail){
        this.large = large;
        this.medium = medium;
        this.thumbnail = thumbnail;
    }

    public Picture (Parcel in)
    {
        this.large = in.readString();
        this.medium = in.readString();
        this.thumbnail = in.readString();
    }

    public static final Parcelable.Creator<Picture> CREATOR= new Parcelable.Creator<Picture>() {
        @Override
        public Picture createFromParcel(Parcel source) {
            return new Picture(source);
        }

        @Override
        public Picture[] newArray(int size) {
            return new Picture[0];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(large);
        dest.writeString(medium);
        dest.writeString(thumbnail);

    }
}
