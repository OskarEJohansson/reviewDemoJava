package org.example.models;

public class Book {
    private String author;
    private String title;
    private String lang;
    private int score;
    private String review;

    public Book(String author, String title, String lang, int score, String review){
        this.author = author;
        this.title = title;
        this.lang = lang;
        this.score = score;
        this.review = review;
    }
    public void setAuthor(String setAuthor){
        this.author = setAuthor;
    }
    public String getAuthor() {
        return author;
    }
    public void setTitle(String setTitle){
        this.title = setTitle;
    }
    public String getTitle() {
        return title;
    }
    public void setLang(String setLang){
        this.lang = setLang;
    }
    public String getLang(){
        return lang;
    }
    public void setScore(int setScore){
        this.score = setScore;
    }
    public int getScore(){
        return score;
    }
    public void setReview(String setReview){
        this.review = review;
    }
    public String getReview(){
        return review;
    }

}


