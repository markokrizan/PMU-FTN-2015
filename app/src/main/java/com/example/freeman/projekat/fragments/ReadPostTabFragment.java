package com.example.freeman.projekat.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.freeman.projekat.R;
import com.example.freeman.projekat.activities.ReadPostsActivity;
import com.example.freeman.projekat.model.Comment;
import com.example.freeman.projekat.model.Post;
import com.example.freeman.projekat.model.Tag;

/**
 * Created by Freeman on 5/8/2018.
 */

public class ReadPostTabFragment  extends Fragment {

    int position;
    private TextView textView;

    public static Fragment getInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        ReadPostTabFragment rptf = new ReadPostTabFragment();
        rptf.setArguments(bundle);
        return rptf;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("pos");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        /*
        Intent intent = getIntent();
        post1 = (Post) intent.getExtras().getSerializable("post1");
        */

        //uzmi post iz bundle-a
        Post post1 = (Post) getArguments().getSerializable("post1");
        View myInflatedView = inflater.inflate(R.layout.read_post_fragment_tab, container,false);



        //punjenje gui-ja - dobijemo iz intenta:

        TextView title = (TextView) myInflatedView.findViewById(R.id.lbltitle);
        title.append(post1.getTitle());
        //moze .setText() ako neces da ostavis ono sto je sad, a verovatno ce tako biti


        TextView description = (TextView) myInflatedView.findViewById(R.id.lbldescription);
        description.append(post1.getDescription());

        ImageView photo = (ImageView) myInflatedView.findViewById(R.id.imgphoto);
        photo.setImageResource(R.drawable.newspaper);

        TextView author = (TextView) myInflatedView.findViewById(R.id.lblauthor);
        author.append(post1.getAuthor().getName());

        TextView datum = (TextView) myInflatedView.findViewById(R.id.lbldate);
        datum.append(post1.getDate().toString());

        /*
        TextView lok = (TextView) findViewById(R.id.lbllocation);
        lok.append(post1.getLocation().toString());
        */




        ArrayAdapter<Tag> tagoviAdapter = new ArrayAdapter<Tag>(getActivity(), android.R.layout.simple_list_item_1, post1.getTags());

        ListView listaTagova = (ListView) myInflatedView.findViewById(R.id.listtags);
        listaTagova.setAdapter(tagoviAdapter);


        ArrayAdapter<Comment> komentariAdapter = new ArrayAdapter<Comment>(getActivity(), android.R.layout.simple_list_item_1, post1.getComments());

        ListView listaKomentara = (ListView) myInflatedView.findViewById(R.id.listcomments);
        listaKomentara.setAdapter(komentariAdapter);


        TextView lajkovi = (TextView) myInflatedView.findViewById(R.id.lbllikes);
        lajkovi.append(Integer.toString(post1.getLikes()));

        TextView dislajkovi = (TextView) myInflatedView.findViewById(R.id.lbldislikes);
        dislajkovi.append(Integer.toString(post1.getDislikes()));


        //return inflater.inflate(R.layout.read_post_fragment_tab, container, false);
        return myInflatedView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        textView = (TextView) view.findViewById(R.id.textView);

        textView.setText("Fragment " + (position + 1));

    }
}