package com.example.mina.newstoday.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class newsContent implements  Parcelable {

    @SerializedName("articles")

   private List<newsObject>articles=new ArrayList<>();

    public newsContent( List<newsObject>articles) {

        this.articles=articles;

    }
    protected newsContent(Parcel in) {

        articles = in.readParcelable(newsContent.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

      dest.writeList(articles);

    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<newsContent> CREATOR = new Creator<newsContent>() {
        @Override
        public newsContent createFromParcel(Parcel in) {
            return new newsContent(in);
        }

        @Override
        public newsContent[] newArray(int size) {
            return new newsContent[size];
        }
    };
    public List<newsObject> getDataList() {
        return articles;
    }

    public void setDataList(List<newsObject> dataList) {
        this.articles = dataList;
    }


}
