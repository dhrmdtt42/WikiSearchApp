package com.wikisearchapp.app;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

class Redirects implements Parcelable {

    @SerializedName("index")
    @Expose
    private int index;

    @SerializedName("from")
    @Expose
    private String from;

    @SerializedName("to")
    @Expose
    private  String to;

    public Redirects() {
    }

    public Redirects(int index, String from, String to) {
        this.index = index;
        this.from = from;
        this.to = to;
    }

    protected Redirects(Parcel in) {
        index = in.readInt();
        from = in.readString();
        to = in.readString();
    }

    public static final Creator<Redirects> CREATOR = new Creator<Redirects>() {
        @Override
        public Redirects createFromParcel(Parcel in) {
            return new Redirects(in);
        }

        @Override
        public Redirects[] newArray(int size) {
            return new Redirects[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(index);
        dest.writeString(from);
        dest.writeString(to);
    }
}
