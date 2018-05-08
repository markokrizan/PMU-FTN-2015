package com.example.freeman.projekat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.freeman.projekat.activities.LoginActivity;


//ovo je aktivnost gde bi se nalazio nekakav splash screen ili slicno, ubija se nakon sto se predje
//u sledecu
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    public void btnLoginActivity(View view) {

        Intent i = new Intent(this, LoginActivity.class );


        startActivity(i);

        finish();
    }
}
