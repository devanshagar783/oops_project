package com.example.mylibrary;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    private static final String TAG = "BookActivity";

    private TextView bookName, authorName, description, pageNumber;
    private ImageView bookImage;
    private Button btnCurReading, btnWantToRead, btnAlreadyRead;

    private Book incomingBook;
    private Util util;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initWidgets();

        Intent intent = getIntent();
        int id= intent.getIntExtra("bookId", 0);
        util = new Util();
        ArrayList<Book> books = util.getAllBooks();
        for(Book b: books){
            if(b.getId() == id){
                incomingBook = b;
                bookName.setText(b.getName());
                authorName.setText(b.getAuthor());
                description.setText(b.getDescription());
                pageNumber.setText("Pages: " + b.getPages());
                Glide.with(this)
                        .asBitmap()
                        .load(b.getImageUrl())
                        .into(bookImage);
            }
        }

        btnCurReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCurReadingTapped();
            }
        });

        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAlreadyReadTapped();
            }
        });

        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnWantToReadTapped();
            }
        });
    }

    private void btnWantToReadTapped(){
        Log.d(TAG, "btnWantToReadTapped: started");

        ArrayList<Book> wantToReadBooks = util.getWantToReadBooks();

        if(wantToReadBooks.contains(incomingBook)){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage("You Already Added this book to your Want to Read List");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            builder.setCancelable(false);
            builder.create().show();
        }
        else{
            util.addWantToReadBook(incomingBook);
            Toast.makeText(this, "The book " + incomingBook.getName() + " Added to your Want to Read Books", Toast.LENGTH_SHORT).show();
        }
    }

    private void btnAlreadyReadTapped(){
        Log.d(TAG, "btnAlreadyReadTapped: started");

        boolean doesExist = false;
        ArrayList<Book> alreadyReadBooks = util.getAlreadyReadBooks();
        for(Book book: alreadyReadBooks){
            if(book.getId() == incomingBook.getId()){
                doesExist = true;
            }
        }

        if(doesExist){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage("You Already Added this book to your Already Read List");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            builder.setCancelable(false);
            builder.create().show();
        }
        else{
            util.addAlreadyReadBook(incomingBook);
            Toast.makeText(this, "The book " + incomingBook.getName() + " Added to your Already Read Books", Toast.LENGTH_SHORT).show();
        }
    }

    private void btnCurReadingTapped(){
        Log.d(TAG, "btnCurReadingTapped: started");

        boolean doesExist = false;
        ArrayList<Book> currentlyReadingBook = util.getCurrentlyReadingBooks();
        for(Book book: currentlyReadingBook){
            if(book.getId() == incomingBook.getId()){
                doesExist = true;
            }
        }

        if(doesExist){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage("You Already Added this book to your Currently Reading List");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            builder.setCancelable(false);
            builder.create().show();
        }
        else{
            util.addCurrentlyReadingBook(incomingBook);
            Toast.makeText(this, "The book " + incomingBook.getName() + " Added to your Currently Reading Book", Toast.LENGTH_SHORT).show();
        }

    }

    private void initWidgets(){
        bookName = (TextView)findViewById(R.id.bookName);
        authorName = (TextView)findViewById(R.id.authorName);
        description = (TextView)findViewById(R.id.bookDescription);
        pageNumber = (TextView)findViewById(R.id.bookPages);

        bookImage = (ImageView)findViewById(R.id.bookImage);

        btnCurReading = (Button)findViewById(R.id.btnCurReading);
        btnWantToRead = (Button)findViewById(R.id.btnWantToRead);
        btnAlreadyRead = (Button)findViewById(R.id.btnAlreadyRead);
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
