package com.sadikali.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sadikali1up on 2016-04-26.
 */
public class Name implements Parcelable{
    public String title;
    public String first;
    public String last;

    public Name (String title, String first, String last){
        this.title = title;
        this.first = first;
        this.last = last;
    }

    public Name (Parcel in)
    {
        this.title = in.readString();
        this.first = in.readString();
        this.last = in.readString();
    }

    public static final Parcelable.Creator<Name> CREATOR= new Parcelable.Creator<Name>() {
        @Override
        public Name createFromParcel(Parcel source) {
            return new Name(source);
        }

        @Override
        public Name[] newArray(int size) {
            return new Name[0];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(first);
        dest.writeString(last);

    }
}
