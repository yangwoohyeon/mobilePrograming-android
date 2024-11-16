package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {
   @Expose
   @SerializedName("text") private String text;
   @SerializedName("result") private String result;

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String getResult(){
        return result;
    }
}