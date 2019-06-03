package com.wikisearchapp.app;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    String BASE_URL = "https://en.wikipedia.org/";

    @GET("/w/api.php?action=query&format=json&prop=pageimages%7Cpageterms&generator=prefixsearch&redirects=1&formatversion=2&piprop=thumbnail&pithumbsize=50&pilimit=10&wbptterms=description")
     Call<SearchResponse> searchResult(
            @Query("gpssearch") String search,
            @Query("gpslimit") int limit);

}
