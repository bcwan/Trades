//referenced from https://www.youtube.com/watch?v=2PIaGpJMCNs&t=191s
//arrow from https://www.google.com/url?sa=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwip_L-ZlafUAhVM6GMKHT1oDPYQjhwIBQ&url=http%3A%2F%2Fwww.clker.com%2Fclipart-arrow-left-2.html&psig=AFQjCNFUEH3QV4IhLWj_vNX6VVIoQERm3A&ust=1496767930134487

package com.cmps115.trades;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import java.util.jar.Attributes;

public class Login extends AppCompatActivity implements View.OnClickListener, GoogleApiClient.OnConnectionFailedListener{


    private SignInButton signInBtn;

    private String name = "Nada Name";
    private String email = "Nada Email";

    private static final String TAG = "Why is it crashing?";
    private GoogleApiClient apiClient;
    private static final int CODE = 9001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        apiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this).addApi(Auth.GOOGLE_SIGN_IN_API, signInOptions).build();


        signInBtn = (SignInButton) findViewById(R.id.signin);


        signInBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.signin:
                signingIn();
                break;

        }


    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFailed:" + connectionResult);

    }


    //
    private void result(GoogleSignInResult r){
        Log.i("visible", r.isSuccess() + "");
        if(r.isSuccess()){

            GoogleSignInAccount account = r.getSignInAccount();

            name = account.getDisplayName();
            Log.i("Login", name + "");
            email = account.getEmail();
            Log.i("Login", email + "");
            switchToProfile();

        }



    }


    public void switchToProfile(){
        Intent i = new Intent(Login.this, ProfileLast.class);
        i.putExtra("Name-passed", getName());
        i.putExtra("Email-passed", getEmail());
        startActivity(i);

    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    //
    private void signingIn(){
        Intent i = Auth.GoogleSignInApi.getSignInIntent(apiClient);
        startActivityForResult(i, CODE);

    }


    @Override
    protected void onActivityResult(int reqCode, int resCode, Intent d) {
        super.onActivityResult(reqCode, resCode, d);

        if(reqCode == CODE){

            GoogleSignInResult r = Auth.GoogleSignInApi.getSignInResultFromIntent(d);
            result(r);

        }
    }
}
