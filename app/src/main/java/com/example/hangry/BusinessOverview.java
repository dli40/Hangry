package com.example.hangry;

import java.util.List;

public class BusinessOverview
{
    private double rating;

    private String price;

    private String phone;

    private String id;

    private String alias;

    private boolean is_closed;

    // List<Categories> categories;

    private int review_count;

    private String name;

    private String url;

    private String image_url;

    private double distance;

    private List<String> transactions;

    public void setRating(int rating){
        this.rating = rating;
    }
    public double getRating(){
        return this.rating;
    }
    public void setPrice(String price){
        this.price = price;
    }
    public String getPrice(){
        return this.price;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setAlias(String alias){
        this.alias = alias;
    }
    public String getAlias(){
        return this.alias;
    }
    public void setIs_closed(boolean is_closed){
        this.is_closed = is_closed;
    }
    public boolean getIs_closed(){
        return this.is_closed;
    }
//    public void setCategories(List<Categories> categories){
//        this.categories = categories;
//    }
//    public List<Categories> getCategories(){
//        return this.categories;
//    }
    public void setReview_count(int review_count){
        this.review_count = review_count;
    }
    public int getReview_count(){
        return this.review_count;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return this.url;
    }
    public void setImage_url(String image_url){
        this.image_url = image_url;
    }
    public String getImage_url(){
        return this.image_url;
    }

    public void setDistance(double distance){
        this.distance = distance;
    }
    public double getDistance(){
        return this.distance;
    }
    public void setTransactions(List<String> transactions){
        this.transactions = transactions;
    }
    public List<String> getTransactions(){
        return this.transactions;
    }
}