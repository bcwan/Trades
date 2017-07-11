package com.cmps115.trades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BuySell extends AppCompatActivity {

    public Button buybutton;

    public void initbuy(){
        buybutton = (Button) findViewById(R.id.buybutton);
        buybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showbuypage = new Intent(BuySell.this, BuyPage.class);
                startActivity(showbuypage);
            }
        });
    }

    public Button sellbutton;
    public void initSell(){
        sellbutton = (Button) findViewById(R.id.sellbutton);
        sellbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showsellpage = new Intent(BuySell.this, SellPage.class);
                startActivity(showsellpage);
            }
        });
    }




    public Button myprofilebutton;
    public void initmyprofile(){
        myprofilebutton = (Button) findViewById(R.id.myprofilebutton);
        myprofilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent showmyprofile = new Intent(BuySell.this, MyProfile.class);
                startActivity(showmyprofile);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_sell);
        initbuy();
        initSell();
        initmyprofile();
    }





}
