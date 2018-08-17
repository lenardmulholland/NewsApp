package com.example.android.newsapp;


public class Article {

    private String mSection;
    private String mArticleTitle;
    private String mAuthor;
    private String mDatePublished;
    private String mArticleUrl;
    private String mSectionColor;

    public Article(String section, String articleTitle, String author, String datePublished, String articleUrl, String sectionColor){
        mSection = section;
        mArticleTitle = articleTitle;
        mAuthor = author;
        mDatePublished = datePublished;
        mArticleUrl = articleUrl;
        mSectionColor = sectionColor;
    }

    public String getSection() {return mSection;}
    public String getArticleTitle() {return mArticleTitle;}
    public String getAuthor() {return mAuthor;}
    public String getDatePublished() {return mDatePublished;}
    public String getArticleUrl() {return mArticleUrl;}
    public String getSectionColor() {return mSectionColor;}
}
