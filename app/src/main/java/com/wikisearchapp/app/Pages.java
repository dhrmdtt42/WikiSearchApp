package com.wikisearchapp.app;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

class Pages  implements Parcelable {

    @SerializedName("pageid")
    @Expose
    private int pageId;

    @SerializedName("ns")
    @Expose
    private int ns;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;

    @SerializedName("terms")
    @Expose
    private Terms terms;

    @SerializedName("index")
    @Expose
    private int index;

    public Pages() {
    }

    public Pages(int pageId, int ns, String title, Thumbnail thumbnail, Terms terms, int index) {
        this.pageId = pageId;
        this.ns = ns;
        this.title = title;
        this.thumbnail = thumbnail;
        this.terms = terms;
        this.index = index;
    }

    protected Pages(Parcel in) {
        pageId = in.readInt();
        ns = in.readInt();
        title = in.readString();
        index = in.readInt();
        thumbnail = in.readParcelable(Thumbnail.class.getClassLoader());
        terms = in.readParcelable(Terms.class.getClassLoader());
    }

    public static final Creator<Pages> CREATOR = new Creator<Pages>() {
        @Override
        public Pages createFromParcel(Parcel in) {
            return new Pages(in);
        }

        @Override
        public Pages[] newArray(int size) {
            return new Pages[size];
        }
    };

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public int getNs() {
        return ns;
    }

    public void setNs(int ns) {
        this.ns = ns;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Terms getTerms() {
        return terms;
    }

    public void setTerms(Terms terms) {
        this.terms = terms;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(pageId);
        dest.writeInt(ns);
        dest.writeString(title);
        dest.writeInt(index);
        dest.writeParcelable( thumbnail, flags);
        dest.writeParcelable(terms, flags);

    }
}
