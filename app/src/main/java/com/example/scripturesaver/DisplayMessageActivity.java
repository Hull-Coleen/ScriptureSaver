package com.example.scripturesaver;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends AppCompatActivity {
    //public static String mypreference = "my perferences";
    private static final String TAG = "Second Page";
    private String userBook;
    private String userChapter;
    private String userVerse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        userBook = intent.getStringExtra(MainActivity.BOOK);
        userChapter = intent.getStringExtra(MainActivity.CHAPTER);
        userVerse = intent.getStringExtra(MainActivity.VERSE);
        String message2 = userBook + " " + userChapter + ": " + userVerse;
        TextView scripture = findViewById(R.id.test);
        scripture.setText(message2);

        TextView textView = findViewById(R.id.textView2);
        textView.setText(message);
        Log.d(TAG, message);
        //super.onBackPressed();
    }

    public void Save(View view) {
        String n = userBook;
        String e = userChapter;
        String v = userVerse;
        SharedPreferences.Editor editor = MainActivity.sharedpreferences.edit();
        editor.putString(MainActivity.BOOK, n).apply();
        editor.putString(MainActivity.CHAPTER, e).apply();
        editor.putString(MainActivity.VERSE, v).apply();
        toastMessage();

    }

    public void toastMessage() {
        Context context = getApplicationContext();
        CharSequence text = "Saved scripture";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
}

}

