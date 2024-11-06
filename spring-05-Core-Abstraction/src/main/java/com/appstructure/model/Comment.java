package com.appstructure.model;

import lombok.Data;

@Data //This lombok Data annotation creates the getter(), setter() and toString() methods for each and every
        //field in class automatically, so no need them to create manually. You can call those methods anywhere that you
        // created the object of this class
public class Comment {
    private String author;
    private String text;
}
