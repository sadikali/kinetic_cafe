package com.sadikali.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by sadikali1up on 2016-04-26.
 */
public class User implements Parcelable{
    public String gender;
    public Name name;
    public Location location;
    public String email;
    public Picture picture;
    public String nat;
    public String phone;



    public User (String gender, String title, String first, String last, String street, String city,
                 String state, String postcode, String email,
                 String large, String medium, String thumbnail, String nat)
    {
        this.gender = gender;
        this.name = new Name(title, first, last);
        this.location = new Location(street, city, state, postcode);
        this.email = email;
        this.picture = new Picture(large, medium, thumbnail);
        this.nat = nat;

    }

    public User(Parcel in){

        this.gender = in.readString();
        this.email = in.readString();
        this.nat = in.readString();
        this.phone = in.readString();
        this.name = in.readParcelable(Name.class.getClassLoader());
        this.location = in.readParcelable(Location.class.getClassLoader());
        this.picture = in.readParcelable(Picture.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.gender);
        dest.writeString(this.email);
        dest.writeString(this.nat);
        dest.writeString(this.phone);
        dest.writeParcelable(this.name, 0);
        dest.writeParcelable(this.location, 0);
        dest.writeParcelable(this.picture, 0);
    }

    public static final Parcelable.Creator<User> CREATOR= new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            throw new UnsupportedOperationException();
        }
    };

    @Override
    public String toString() {
        return name.first + " " + name.last;
    }

}
