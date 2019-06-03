package com.wikisearchapp.app;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SearchResponse  implements Parcelable {

    @SerializedName("batchcomplete")
    @Expose
    private Boolean batchComplete;

    @SerializedName("continue")
    private Continue cont;

    @SerializedName("query")
    @Expose
    private Query query;

//    @SerializedName("redirects")
//    @Expose
//    private ArrayList<Redirects> redirects;
//

    protected SearchResponse(Parcel in) {
        byte tmpBatchComplete = in.readByte();
        batchComplete = tmpBatchComplete == 0 ? null : tmpBatchComplete == 1;
        cont = in.readParcelable(Continue.class.getClassLoader());
        query = in.readParcelable(Query.class.getClassLoader());
    }

    public static final Creator<SearchResponse> CREATOR = new Creator<SearchResponse>() {
        @Override
        public SearchResponse createFromParcel(Parcel in) {
            return new SearchResponse(in);
        }

        @Override
        public SearchResponse[] newArray(int size) {
            return new SearchResponse[size];
        }
    };

    public Boolean getBatchComplete() {
        return batchComplete;
    }

    public void setBatchComplete(Boolean batchComplete) {
        this.batchComplete = batchComplete;
    }

    public Continue getCont() {
        return cont;
    }

    public void setCont(Continue cont) {
        this.cont = cont;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte((byte) (batchComplete == null ? 0 : batchComplete ? 1 : 2));
        dest.writeParcelable(cont, flags);
        dest.writeParcelable(query, flags);
    }
//
//    public ArrayList<Redirects> getRedirects() {
//        return redirects;
//    }
//
//    public void setRedirects(ArrayList<Redirects> redirects) {
//        this.redirects = redirects;
//    }
//
//
}
