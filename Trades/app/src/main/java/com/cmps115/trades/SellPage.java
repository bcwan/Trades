package com.cmps115.trades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SellPage extends AppCompatActivity {
    //View Refs
    private Button vSubmit;
    private EditText vSkill;
    private EditText vDesc;

    //Database Refs
    private FirebaseDatabase mDatabase;
    private DatabaseReference mListingRef;

    private String writeNewListing(String name, String desc){
        String listId;
        ListingEntry listing = new ListingEntry(name,ProfileLast.currUser,desc);
        mListingRef.push().setValue(listing);
        return listId = mListingRef.getKey();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_page);

        //View References
        vSubmit = (Button) findViewById(R.id.Submit_Button);
        vSkill = (EditText) findViewById(R.id.Skill_Text);
        vDesc = (EditText) findViewById(R.id.Desc_Text);

        //Database References
        mDatabase = FirebaseDatabase.getInstance();
        mListingRef = mDatabase.getReference().child("listings");

        vSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String lName = vSkill.getText().toString();
                String lDesc = vDesc.getText().toString();
                writeNewListing(lName, lDesc);

                Intent showbuysellpage = new Intent(SellPage.this, BuySell.class);
                startActivity(showbuysellpage);
            }
        });
    }
}
