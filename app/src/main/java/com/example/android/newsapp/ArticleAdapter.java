package com.example.android.newsapp;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ArticleAdapter extends ArrayAdapter<Article> {
    private static final String LOG_TAG = "ARTICLE_ADAPTER";

    public ArticleAdapter(Activity context, ArrayList<Article> articles) {
        super(context, 0, articles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Article currentArticle = getItem(position);

        TextView sectionTextView = listItemView.findViewById(R.id.section_text_view);
        sectionTextView.setText(currentArticle.getSection());
        sectionTextView.setTextColor(correctColor(currentArticle.getSectionColor()));

        TextView articleTitleTextView = listItemView.findViewById(R.id.article_title_text_view);
        articleTitleTextView.setText(currentArticle.getArticleTitle());

        TextView authorTextView = listItemView.findViewById(R.id.author_text_view);
        authorTextView.setText(currentArticle.getAuthor());

        TextView datePublishedTextView = listItemView.findViewById(R.id.date_published_text_view);
        datePublishedTextView.setText(FormattedDate(currentArticle.getDatePublished()));

        return listItemView;
    }

    private int correctColor (String sectionColor){
        int sectionColorResourceId;
        switch (sectionColor){
            case "News":
                sectionColorResourceId = R.color.news;
                break;
            case "Opinion":
                sectionColorResourceId = R.color.opinion;
                break;
            case "Sport":
                sectionColorResourceId = R.color.sport;
                break;
            case "Arts":
                sectionColorResourceId = R.color.arts;
                break;
            case "Lifestyle":
                sectionColorResourceId = R.color.lifestyle;
                break;
            default:
                sectionColorResourceId = R.color.unknown;
                break;
        }
        return ContextCompat.getColor(getContext(), sectionColorResourceId);
    }

    private String FormattedDate(String dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");

        try {
            Date articleDate = dateFormat.parse(dateObject);
            dateFormat.applyPattern("LLL dd, yyyy");
            return dateFormat.format(articleDate);
        } catch (ParseException e) {
            Log.e(LOG_TAG, "Problem formatting data.", e);
            return null;
        }
    }
}

