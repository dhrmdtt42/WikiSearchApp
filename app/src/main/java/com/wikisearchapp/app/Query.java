package com.wikisearchapp.app;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class Query implements Parcelable {

    @SerializedName("redirects")
    @Expose
    private ArrayList<Redirects> redirects;

    @SerializedName("pages")
    @Expose
    private ArrayList<Pages> pages;

    public Query() {
    }

    public Query(ArrayList<Redirects> redirects, ArrayList<Pages> pages) {
        this.redirects = redirects;
        this.pages = pages;
    }

    protected Query(Parcel in) {
        pages = in.createTypedArrayList(Pages.CREATOR);
        redirects = in.createTypedArrayList(Redirects.CREATOR);
    }

    public static final Creator<Query> CREATOR = new Creator<Query>() {
        @Override
        public Query createFromParcel(Parcel in) {
            return new Query(in);
        }

        @Override
        public Query[] newArray(int size) {
            return new Query[size];
        }
    };

    public ArrayList<Redirects> getRedirects() {
        return redirects;
    }

    public void setRedirects(ArrayList<Redirects> redirects) {
        this.redirects = redirects;
    }

    public ArrayList<Pages> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Pages> pages) {
        this.pages = pages;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(pages);
        dest.writeTypedList(redirects);
    }
}
