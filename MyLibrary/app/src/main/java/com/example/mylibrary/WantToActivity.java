package com.example.mylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

public class WantToActivity extends AppCompatActivity {
    private static final String TAG = "WantToActivity";

    private RecyclerView recyclerView;

    private BooksRecViewAdapter adapter;
    private Util utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_to);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter = new BooksRecViewAdapter(this);
        utils = new Util();

        recyclerView = (RecyclerView)findViewById(R.id.recView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        adapter.setBooks(utils.getWantToReadBooks());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
