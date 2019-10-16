package com.example.mylibrary;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BooksRecViewAdapter extends RecyclerView.Adapter<BooksRecViewAdapter.ViewHolder>{
    private static final String TAG = "BooksRecViewAdapter";

    private ArrayList<Book> books = new ArrayList<>();
    private Context context;


    public BooksRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_book_rec_view,viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Log.d(TAG, "onBindViewHolder: called");
        viewHolder.bookName.setText(books.get(i).getName());

        viewHolder.bookCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, BookActivity.class);
                intent.putExtra("bookId", books.get(i).getId());
                context.startActivity(intent);
            }
        });

        Glide.with(context)
                .asBitmap()
                .load(books.get(i).getImageUrl())
                .into(viewHolder.bookImage);


    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView bookImage;
        private TextView bookName;
        private CardView bookCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bookImage = (ImageView)itemView.findViewById(R.id.bookImage);
            bookName = (TextView)itemView.findViewById(R.id.bookName);
            bookCard = (CardView)itemView.findViewById(R.id.bookCard);
        }
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }
}
