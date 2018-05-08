package com.example.freeman.projekat.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Freeman on 4/4/2018.
 */

public class Tag implements Serializable {

    private int id;
    private String name;
    private List<Post> posts;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }


    @Override
    public String toString(){
        return this.name;
    }
}
