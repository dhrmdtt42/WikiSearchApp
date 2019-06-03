package com.wikisearchapp.app;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Continue implements Parcelable {

    @SerializedName("gpsoffset")
    @Expose
    private int gpsoffset;

    @SerializedName("continue")
    @Expose
    private String conti;


    public Continue() {
    }

    public Continue(int gpsoffset, String conti) {
        this.gpsoffset = gpsoffset;
        this.conti = conti;
    }

    protected Continue(Parcel in) {
        gpsoffset = in.readInt();
        conti = in.readString();
    }

    public static final Creator<Continue> CREATOR = new Creator<Continue>() {
        @Override
        public Continue createFromParcel(Parcel in) {
            return new Continue(in);
        }

        @Override
        public Continue[] newArray(int size) {
            return new Continue[size];
        }
    };

    public int getGpsoffset() {
        return gpsoffset;
    }

    public void setGpsoffset(int gpsoffset) {
        this.gpsoffset = gpsoffset;
    }

    public String getConti() {
        return conti;
    }

    public void setConti(String conti) {
        this.conti = conti;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(gpsoffset);
        dest.writeString(conti);
    }
}
