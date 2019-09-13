package com.example.hangry;

import java.util.List;

//GET https://api.yelp.com/v3/businesses/search
public class BusinessSearch
{
    private int total;

    private List<BusinessOverview> businesses;

    public void setTotal(int total){
        this.total = total;
    }
    public int getTotal(){
        return this.total;
    }
    public void setBusinesses(List<BusinessOverview> businesses){
        this.businesses = businesses;
    }
    public List<BusinessOverview> getBusinesses() {
        return this.businesses;
    }
}