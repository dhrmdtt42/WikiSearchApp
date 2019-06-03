package com.wikisearchapp.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SearchResult extends AppCompatActivity implements  SearchAdapter.OnclickListener{
    private RecyclerView rec_search;
    private SearchAdapter searchAdapter;
    private ArrayList<Pages> listItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        rec_search = findViewById(R.id.rec_search);
        listItems= new ArrayList<>();



        searchAdapter = new SearchAdapter(getBaseContext(), listItems, this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(SearchResult.this, 1, false);
        rec_search.setLayoutManager(linearLayoutManager);
        rec_search.setAdapter(searchAdapter);
        listItems = getIntent().getParcelableArrayListExtra("searchResult");
        searchAdapter.setList(listItems);
    }

    @Override
    public void OnItemClick(Pages pageItem) {

    }
}
