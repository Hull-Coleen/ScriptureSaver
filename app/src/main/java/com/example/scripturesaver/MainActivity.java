package com.example.scripturesaver;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final String TAG = "Main intent ";
    public static final String BOOK = "Book";
    public static final String CHAPTER = "Chapter";
    public static final String VERSE = "Verse";
    public static SharedPreferences sharedpreferences;
    TextView book;
    TextView chapter;
    TextView verse;
    public static String mypreference = "pref";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText book = (EditText) findViewById(R.id.editBook);
        EditText chapter = (EditText) findViewById(R.id.editChapter);
        EditText verse = (EditText) findViewById(R.id.editVerse);
        String scriptureBook = book.getText().toString();
        String scriptureChapter = chapter.getText().toString();
        String scriptureVerse = verse.getText().toString();
        String userBook = book.getText().toString() + "  " + chapter.getText().toString() + " : "
                + verse.getText().toString();
        intent.putExtra(BOOK, scriptureBook);
        intent.putExtra(CHAPTER, scriptureChapter);
        intent.putExtra(VERSE, scriptureVerse);
        intent.putExtra(EXTRA_MESSAGE, userBook);
        startActivity(intent);
        Log.i(TAG, userBook);
    }
    public void Get(View view) {
        book = (EditText) findViewById(R.id.editBook);
        chapter = (EditText) findViewById(R.id.editChapter);
        verse = (EditText) findViewById(R.id.editVerse);
        sharedpreferences = getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);

        if (sharedpreferences.contains(BOOK)) {
            book.setText(sharedpreferences.getString(BOOK, ""));
        }
        if (sharedpreferences.contains(CHAPTER)) {
            chapter.setText(sharedpreferences.getString(CHAPTER, ""));

        }
        if (sharedpreferences.contains(VERSE)) {
            verse.setText(sharedpreferences.getString(VERSE, ""));
        }
    }



}
