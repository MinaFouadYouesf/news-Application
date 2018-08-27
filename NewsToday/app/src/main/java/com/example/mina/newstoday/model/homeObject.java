package com.example.mina.newstoday.model;

public class homeObject {
 private int img;
 private  String title;
 public homeObject(int img,String title){
     this.img=img;
     this.title=title;
   }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
