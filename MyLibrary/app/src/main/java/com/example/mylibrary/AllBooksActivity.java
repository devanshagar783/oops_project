package com.example.mylibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
    private static final String TAG = "AllBooksActivity";

    private RecyclerView booksRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        Log.d(TAG, "onCreate: started");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        booksRecView = (RecyclerView)findViewById(R.id.booksRecView);


        BooksRecViewAdapter adapter = new BooksRecViewAdapter(this);
        booksRecView.setAdapter(adapter);
        booksRecView.setLayoutManager(new GridLayoutManager(this, 2));

        Util util = new Util();
        ArrayList<Book> books = new ArrayList<>();
        books = util.getAllBooks();
        adapter.setBooks(books);
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
