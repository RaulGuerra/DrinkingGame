package com.cs4750.android.truthordrink;

public class User {
    private int score;
    public User(){
        score = 0;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score){
        this.score = score;
    }
    public void incrementScore(){
        this.score++;
    }
}
