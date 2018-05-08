package com.example.freeman.projekat.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.freeman.projekat.R;
import com.example.freeman.projekat.model.Post;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Freeman on 5/7/2018.
 */

public class PostAdapter extends ArrayAdapter<Post> implements View.OnClickListener {

    private ArrayList<Post> postovi;
    Context mContext;

    //kesiranje view-ova
    private static class ViewHolder{
        ImageView slika;
        TextView naziv;
        TextView opis;
    }


    public PostAdapter(ArrayList<Post> postovi, Context context){
        super(context, R.layout.row_item_posts, postovi);
        this.postovi = postovi;
        this.mContext = context;

    }

    //listener za stavku
    @Override
    public void onClick(View view) {
        int position = (Integer) view.getTag();
        Object object = getItem(position);
        //kastujes objekat u konkretan post
        Post post = (Post)object;

        //mozes da reagujes posebno na naslov, opis ili sliku
        switch (view.getId()){
            case R.id.naziv:
                Snackbar.make(view, "Naslov: " + post.getTitle(), Snackbar.LENGTH_SHORT).setAction("No action", null).show();
                break;
            case R.id.opis:
                Snackbar.make(view, "Opis: " + post.getDescription(), Snackbar.LENGTH_SHORT).setAction("No action", null).show();
                break;
            case R.id.slika:
                Snackbar.make(view, "Dalje na post", Snackbar.LENGTH_SHORT).setAction("No action", null).show();
                break;
        }

    }

    //???
    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Post post = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_item_posts, parent, false);
            viewHolder.naziv = (TextView) convertView.findViewById(R.id.naziv);
            viewHolder.opis = (TextView) convertView.findViewById(R.id.opis);
            viewHolder.slika = (ImageView) convertView.findViewById(R.id.slika);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.naziv.setText(post.getTitle());
        viewHolder.opis.setText(post.getDescription());
        viewHolder.slika.setOnClickListener(this);
        viewHolder.slika.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}
