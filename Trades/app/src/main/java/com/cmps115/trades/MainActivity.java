package com.cmps115.trades;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseProfRef;

    public static final String tag = "On Create!";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(tag, "onCreate");

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseProfRef = mFirebaseDatabase.getReference().child("profiles");
    }

}
