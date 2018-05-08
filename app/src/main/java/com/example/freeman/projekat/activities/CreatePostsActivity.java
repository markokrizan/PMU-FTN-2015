package com.example.freeman.projekat.activities;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.freeman.projekat.R;

public class CreatePostsActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_posts);


        //toolbar:
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //This method sets the toolbar as the app bar for the activity.
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);


        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        //menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        switch (menuItem.getItemId()) {
                            case R.id.nav_posts_prikaz_objava:

                                Intent a = new Intent(CreatePostsActivity.this, PostsActivity.class);
                                startActivity(a);

                                break;
                            case R.id.nav_posts_pravljenje_objave:

                                Intent b = new Intent(CreatePostsActivity.this, CreatePostsActivity.class);
                                startActivity(b);

                                break;
                            case R.id.nav_posts_settings:

                                Intent c = new Intent(CreatePostsActivity.this, SettingsActivity.class);
                                startActivity(c);

                                break;
                        }



                        return true;
                    }
                });

        //ako zatreba, osluskivac na uvlacenje i izvlacenje navigation drawera
        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.createpoststoolbarmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.cpmenupotvrdi: {
                Toast.makeText(this, "Potvrdi pravljanje",
                        Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.cpmenuodustani: {
                Toast.makeText(this, "Odustani od pravljenja",
                        Toast.LENGTH_SHORT).show();
                break;
            }
        }
        return super.onOptionsItemSelected(item);
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


    public void btnObjavi(View view) {

        //handler za objavi
    }

    public void btnGalerija(View view) {
        Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        if (openGalleryIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(openGalleryIntent, 1);
        }
    }


    public void btnKamera(View view) {
        Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Checking if there's at least one camera app
        if (openCameraIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(openCameraIntent, 1);
        }
    }
}
