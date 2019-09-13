package com.example.hangry;

import java.util.List;
public class BusinessDetail
{
    //GET https://api.yelp.com/v3/businesses/{id}

    //TODO: need to have different serialize name for location
    private String id;

    private String alias;

    private String name;

    private String image_url;

    private boolean is_claimed;

    private boolean is_closed;

    private String url;

    private String phone;

    private String display_phone;

    private int review_count;

    //private List<Categories> categories;

    private double rating;

    private BusinessLocation location;

    //private Coordinates coordinates;

    private List<String> photos;

    private String price;

    //private List<Hours> hours;

    //private List<String> transactions;

    //private List<Special_hours> special_hours;

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
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setImage_url(String image_url){
        this.image_url = image_url;
    }
    public String getImage_url(){
        return this.image_url;
    }
    public void setIs_claimed(boolean is_claimed){
        this.is_claimed = is_claimed;
    }
    public boolean getIs_claimed(){
        return this.is_claimed;
    }
    public void setIs_closed(boolean is_closed){
        this.is_closed = is_closed;
    }
    public boolean getIs_closed(){
        return this.is_closed;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return this.url;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setDisplay_phone(String display_phone){
        this.display_phone = display_phone;
    }
    public String getDisplay_phone(){
        return this.display_phone;
    }
    public void setReview_count(int review_count){
        this.review_count = review_count;
    }
    public int getReview_count(){
        return this.review_count;
    }
//    public void setCategories(List<Categories> categories){
//        this.categories = categories;
//    }
//    public List<Categories> getCategories(){
//        return this.categories;
//    }
    public void setRating(double rating){
        this.rating = rating;
    }
    public double getRating(){
        return this.rating;
    }
    public void setLocation(BusinessLocation location){
        this.location = location;
    }
    public BusinessLocation getLocation(){
        return this.location;
    }
//    public void setCoordinates(Coordinates coordinates){
//        this.coordinates = coordinates;
//    }
//    public Coordinates getCoordinates(){
//        return this.coordinates;
//    }
    public void setPhotos(List<String> photos){
        this.photos = photos;
    }
    public List<String> getPhotos(){
        return this.photos;
    }
    public void setPrice(String price){
        this.price = price;
    }
    public String getPrice(){
        return this.price;
    }
//    public void setHours(List<Hours> hours){
//        this.hours = hours;
//    }
//    public List<Hours> getHours(){
//        return this.hours;
//    }
//    public void setTransactions(List<String> transactions){
//        this.transactions = transactions;
//    }
//    public List<String> getTransactions(){
//        return this.transactions;
//    }
//    public void setSpecial_hours(List<Special_hours> special_hours){
//        this.special_hours = special_hours;
//    }
//    public List<Special_hours> getSpecial_hours(){
//        return this.special_hours;
//    }
}
