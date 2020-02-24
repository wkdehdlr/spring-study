package com.example.demo;

public interface CommentSummary {
    String getComment();

    int getUp();

    int getDown();

   default String getVotes(){
       return getUp() + " " + getDown();
   }
}
