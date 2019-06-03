package com.wikisearchapp.app;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {


    private EditText search_txt;
    private Button search_btn;
    private String searchString;
    private int NO_OF_SEARCH_RESULT  =  10;
    private ArrayList<Pages> pagelist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_txt = findViewById(R.id.search_text);
        search_btn = findViewById(R.id.search_btn);

//        pagelist = new ArrayList<>();



        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchString = search_txt.getText().toString().trim();

                if(searchString.contains(" ")){
                    searchString.replace(' ','+');
                }

                callApiForWikiResult(searchString);
            }
        });

    }

    private void callApiForWikiResult(String searchString) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://en.wikipedia.org//")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<SearchResponse> call =  apiInterface.searchResult(searchString, NO_OF_SEARCH_RESULT);

       call.enqueue(new Callback<SearchResponse>() {
           @Override
               public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {

               if (! response.isSuccessful()){

                   Toast.makeText(getApplicationContext(), response.code(), Toast.LENGTH_SHORT).show();
               }else {

                   SearchResponse searchResponse = response.body();
                   Log.d("list", searchResponse +"");
                   pagelist  = searchResponse.getQuery().getPages();

                   Intent intent = new Intent(MainActivity.this, SearchResult.class);
                   intent.putExtra("searchResult", pagelist);
                   startActivity(intent);


               }
           }

           @Override
           public void onFailure(Call<SearchResponse> call, Throwable t) {

               Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });

    }
}
