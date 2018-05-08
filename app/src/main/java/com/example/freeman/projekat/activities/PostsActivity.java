package com.example.freeman.projekat.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.freeman.projekat.R;
import com.example.freeman.projekat.adapters.PostAdapter;
import com.example.freeman.projekat.model.Comment;
import com.example.freeman.projekat.model.Post;
import com.example.freeman.projekat.model.Tag;
import com.example.freeman.projekat.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class PostsActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private static PostAdapter adapter;

    private ArrayList<Post> postovi = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                mDrawerLayout.closeDrawers();

                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here

                switch (menuItem.getItemId()) {
                    case R.id.nav_posts_prikaz_objava:

                        Intent a = new Intent(PostsActivity.this, PostsActivity.class);
                        startActivity(a);

                        break;
                    case R.id.nav_posts_pravljenje_objave:

                        Intent b = new Intent(PostsActivity.this, CreatePostsActivity.class);
                        startActivity(b);

                        break;
                    case R.id.nav_posts_settings:

                        Intent c = new Intent(PostsActivity.this, SettingsActivity.class);
                        startActivity(c);

                        break;
                }

                return true;

            }
        });



        //dummy objekti za prikaz

        //ovo si sad uradio i nikad vise
        //Bitmap slika = BitmapFactory.decodeResource(getResources(), R.drawable.login);

        User autorPosta = new User();
        autorPosta.setId(1);
        autorPosta.setName("Autor posta");

        User autorKomentara = new User();
        autorKomentara.setId(2);
        autorKomentara.setName("Autor komentara");

        /*
        Location lokacija = new Location("");
        lokacija.setLatitude(0.0d);
        lokacija.setLongitude(0.0d);
        */

        Tag tag1 = new Tag();
        tag1.setId(1);
        tag1.setName("Tag1");

        Tag tag2 = new Tag();
        tag2.setId(2);
        tag2.setName("Tag2");

        ArrayList<Tag> tagovi = new ArrayList<Tag>();
        tagovi.add(tag1);
        tagovi.add(tag2);

        Comment komentar1 = new Comment();
        komentar1.setId(1);
        komentar1.setAuthor(autorKomentara);
        komentar1.setDate(new Date());
        komentar1.setDescription("Neki komentar");
        komentar1.setDislikes(3);
        komentar1.setLikes(2);
        komentar1.setTitle("Naslov prvog komentara");

        Comment komentar2 = new Comment();
        komentar2.setId(2);
        komentar2.setAuthor(autorKomentara);
        komentar2.setDate(new Date());
        komentar2.setDescription("Neki drugi komentar");
        komentar2.setDislikes(7);
        komentar2.setLikes(4);
        komentar2.setTitle("Naslov drugog komentara");

        ArrayList<Comment> komentari = new ArrayList<Comment>();
        komentari.add(komentar1);
        komentari.add(komentar2);






        ///-----------------------------------------
        final Post post1 = new Post();

        post1.setId(1);
        post1.setTitle("Neka vest");
        post1.setDescription("Opis neke vesti");
        //post1.setPhoto(slika);
        post1.setAuthor(autorPosta);
        post1.setDate(new Date());
        //post1.setLocation(lokacija);
        post1.setTags(tagovi);
        post1.setComments(komentari);
        post1.setLikes(40);
        post1.setDislikes(50);

        final Post post2 = new Post();

        post2.setId(1);
        post2.setTitle("Neka druga vest");
        post2.setDescription("Opis neke druge vesti");
        //post1.setPhoto(slika);
        post2.setAuthor(autorPosta);
        post2.setDate(new Date());
        //post1.setLocation(lokacija);
        post2.setTags(tagovi);
        post2.setComments(komentari);
        post2.setLikes(80);
        post2.setDislikes(30);

        //final   ArrayList<Post> postovi = new ArrayList<>();
        //postovi.add(post1);
        //postovi.add(post2);

        postovi.add(post1);
        postovi.add(post2);




        //sortiraj kolekciju pre nego sto je prosledis adapteru
        //Sortiraj(postovi);

        ListView listaPostova = (ListView) findViewById(R.id.postsList);

        adapter = new PostAdapter(postovi, getApplicationContext());

        listaPostova.setAdapter(adapter);




        /*
        ArrayAdapter<Post> postoviAdapter = new ArrayAdapter<Post>(this, android.R.layout.simple_list_item_1, postovi);
        listaPostova.setAdapter(postoviAdapter);



        listaPostova.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        //i je pozicija
                        //proveri makar koji je kliknut, jebeni budz
                        Intent intent = new Intent(view.getContext(), ReadPostsActivity.class );
                        intent.putExtra("post1", postovi.get(i));
                        startActivity(intent);


                    }
                }


        );
        */

        listaPostova.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Post post= postovi.get(position);
                Intent intent = new Intent(view.getContext(), ReadPostsActivity.class );
                intent.putExtra("post1", post);
                startActivity(intent);
            }
        });









    }

    //metoda za sortiranje postova
    public void Sortiraj(ArrayList<Post> posts){
        //uzmi podesavanje iz preferences
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String sortPostsBy = sp.getString("lpSortPostsBy", "Datumu");

        // Sortiraj po tome
        if(sortPostsBy.equals("Datumu")) {
            Collections.sort(posts, new Comparator<Post>() {
                @Override
                public int compare(Post post1, Post post2) {
                    return post1.getDate().compareTo(post2.getDate());
                }
            });
        } else if (sortPostsBy.equals("Popularnosti")) {
            Collections.sort(posts, new Comparator<Post>() {
                @Override
                public int compare(Post post2, Post post1) {
                    if(post1.getLikes() > post2.getLikes()){
                        return 1;
                    } else if (post1.getLikes() < post2.getLikes()){
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
        } else {
            Toast.makeText(this, "Nastao svinjac kod sortiranja po : " + sortPostsBy, Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.poststoolbarmenu, menu);
        return true;
    }

    //osluskivac za meni
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.pmenuobjavi: {
                Toast.makeText(this, "Objavi",
                        Toast.LENGTH_SHORT).show();
                break;
            }



                //ovde stavi intent da ide u CreatePosts

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
        //moras da sortiras ponovo pri resumu aktivnosti da bi video promene:
        Sortiraj(postovi);

        ListView listaPostova = (ListView) findViewById(R.id.postsList);

        adapter = new PostAdapter(postovi, getApplicationContext());

        listaPostova.setAdapter(adapter);

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



    public void btnCreatePosts(View view) {

        Intent i = new Intent(this, CreatePostsActivity.class );


        startActivity(i);
    }

    public void btnReadPosts(View view) {

        Intent i = new Intent(this, ReadPostsActivity.class );


        startActivity(i);
    }

    public void btnSettings(View view) {

        Intent i = new Intent(this, SettingsActivity.class );


        startActivity(i);
    }
}
