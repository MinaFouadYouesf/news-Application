package com.example.mina.newstoday.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class newsObject implements Parcelable {
    @SerializedName("author")
    private String author;
    @SerializedName("title")
    private String  title;
    @SerializedName("description")
    private String  description;
    @SerializedName("url")
    private String  url;
    @SerializedName("urlToImage")
    private String urlToImage;
    @SerializedName("publishedAt")
    private String  publishedAt;
    public newsObject(String author,String title,String description,String url,String urlToImage,String publishedAt){

        this.author=author;
        this.title=title;
        this.url=url;
        this.urlToImage=urlToImage;
        this.publishedAt=publishedAt;
        this.description=description;

    }
    protected newsObject(Parcel in) {
        author = in.readString();
        title = in.readString();
        url = in.readString();
        urlToImage = in.readString();
        publishedAt = in.readString();
        description = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(author);
        dest.writeString(title);
        dest.writeString(url);
        dest.writeString(urlToImage);
        dest.writeString(publishedAt);
        dest.writeString(description);
    }

    @Override
    public int describeContents(){
        return 0;
    }

    public static final Creator<newsObject> CREATOR = new Creator<newsObject>() {
        @Override
        public newsObject createFromParcel(Parcel in) {
            return new newsObject(in);
        }

        @Override
        public newsObject[] newArray(int size) {
            return new newsObject[size];
        }
    };
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getAuthor( ) {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

}
