package com.cmps115.trades;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MyProfile extends AppCompatActivity {

    //View Refs
    private ImageView imageView;
    private TextView name;
    private TextView email;
    private TextView phone;

    /* Removed due to time constraints
    public Button editprofilebutton;
    public void initEditProfile(){
        editprofilebutton = (Button) findViewById(R.id.editprofile);
        editprofilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showeditpage = new Intent(MyProfile.this, EditMyProfile.class);
                startActivity(showeditpage);
            }
        });
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        //initEditProfile();

        //View Refs
        imageView = (ImageView) findViewById(R.id.profileimage);
        name = (TextView) findViewById(R.id.first);
        email = (TextView) findViewById(R.id.email);
        phone = (TextView) findViewById(R.id.phonenumber);

        //decode encoded image from server and paste into imageView
        String encodedString = ProfileLast.currUser.getMyImage();
        byte[] decodedString = Base64.decode(encodedString, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        imageView.setImageBitmap(decodedByte);

        String emailEDU = ProfileLast.currUser.getEmail()+".edu";

        name.setText(ProfileLast.currUser.getName());
        email.setText(emailEDU);
        phone.setText(ProfileLast.currUser.getPhone());
    }
}
