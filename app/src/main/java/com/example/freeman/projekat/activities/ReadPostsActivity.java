package com.example.freeman.projekat.activities;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.freeman.projekat.R;
import com.example.freeman.projekat.adapters.ReadPostPagerAdapter;
import com.example.freeman.projekat.fragments.ReadCommentsTabFragment;
import com.example.freeman.projekat.fragments.ReadPostTabFragment;
import com.example.freeman.projekat.model.Comment;
import com.example.freeman.projekat.model.Post;
import com.example.freeman.projekat.model.Tag;


public class ReadPostsActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    private Toolbar toolbar;

    //tabs:
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Post post1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_posts);

        Toolbar toolbar = (Toolbar) findViewById(R.id.readtoolbar);
        //This method sets the toolbar as the app bar for the activity.
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionbar.setDisplayHomeAsUpEnabled(true);


        //tabs:
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        ReadPostPagerAdapter adapter = new ReadPostPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);




        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

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

                                Intent a = new Intent(ReadPostsActivity.this, PostsActivity.class);
                                startActivity(a);

                                break;
                            case R.id.nav_posts_pravljenje_objave:

                                Intent b = new Intent(ReadPostsActivity.this, CreatePostsActivity.class);
                                startActivity(b);

                                break;
                            case R.id.nav_posts_settings:

                                Intent c = new Intent(ReadPostsActivity.this, SettingsActivity.class);
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


        Intent intent = getIntent();
        post1 = (Post) intent.getExtras().getSerializable("post1");



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.readpoststoolbarmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: {
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;

            }
            case R.id.rpmenuobrisi: {
                Toast.makeText(this, "Potvrdi pravljanje",
                        Toast.LENGTH_SHORT).show();
                break;
            }


            // case blocks for other MenuItems (if any)
        }
        return super.onOptionsItemSelected(item);
    }



    //tabovi - fragmenti
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        // The post that the adapter is showing
        private Post fragmentPost;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
            this.fragmentPost = post1;
        }


        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            Bundle bundle = new Bundle();
            bundle.putSerializable("post1", this.fragmentPost);
            switch (position) {
                case 0:
                    ReadPostTabFragment rptf = new ReadPostTabFragment();
                    rptf.setArguments(bundle);
                    return rptf;
                case 1:
                    ReadCommentsTabFragment rctf = new ReadCommentsTabFragment();
                    rctf.setArguments(bundle);
                    return rctf;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
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
}
