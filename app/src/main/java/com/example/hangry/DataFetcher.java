package com.example.hangry;

import android.content.res.Resources;
import android.provider.ContactsContract;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface DataFetcher
{


    //GET https://api.yelp.com/v3/businesses/search

    //String mystring = getResources().getString(R.string.mystring);
    @Headers("Authorization: Bearer "+ R.string.apiKey)
    @GET("businesses/search")
    Call<BusinessSearch> searchBusinesses(@Query("term") String term, @Query("latitude") Double lat,
                                          @Query("longitude") Double lon,@Query("limit") Integer lim,
                                          @Query("open_now") boolean openNow);


    //string term, double latitude, double longitude, limit int,open_now  bool

    //GET https://api.yelp.com/v3/businesses/{id}
    @Headers("Authorization: Bearer "+R.string.apiKey)
    @GET("businesses/{id}")
    Call<BusinessDetail> getBusinessDetailed(@Path("id") String id);
}


