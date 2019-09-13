package com.example.hangry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Location mLocation = null;
    private FusedLocationProviderClient fusedLocationClient;
    private Retrofit retrofit;
    private DataFetcher dataFetcher;
    private List<String> restIds= new ArrayList<>(50);
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        random=new Random();
        Log.i("FOOD","CREATED!");
    }

    public void onMainButtonClick(View view)
    {
        //fetch location
        handlePermissions();//getlocation is called within that once verified

    }
    public void getLocation()
    {
       fusedLocationClient.getLastLocation()
               .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                   @Override
                   public void onSuccess(Location location) {
                       if(location!=null)
                       {
                           mLocation = location;

                           Log.i("FOOD","lcoation is: "+mLocation.getLatitude()+", "+mLocation.getLongitude());
                           retrofit = createApiFactory();
                           Log.i("FOOD","CREATEd Retrofit instance");
                           dataFetcher = retrofit.create(DataFetcher.class);
                           Log.i("FOOD","Created api service class");
                           searchForBusinesses(dataFetcher);


                           //int size = restIds.size();
                           //String id = restIds.get(random.nextInt(size));
                           //Log.i("FOOD","random id is: "+id);
                           //getBusinessDetails(dataFetcher,id);

                       }
                       else
                       {
                           Log.i("FOOD","NO Location found!");
                       }
                   }
               });
    }
    private Retrofit createApiFactory()
    {
        return new Retrofit.Builder()
                .baseUrl("https://api.yelp.com/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
    private void getBusinessDetails(DataFetcher df,String id)
    {
        Call<BusinessDetail> details = df.getBusinessDetailed(id);
        details.enqueue(new Callback<BusinessDetail>() {
            @Override
            public void onResponse(Call<BusinessDetail> call, Response<BusinessDetail> response) {
                if(response.isSuccessful())
                {
                    Log.i("FOOD","BUSINESS DETAIL Response success!");
                }
                else
                {
                    Log.i("FOOD","Unsuccessful Besuiness Detail Response!!");
                }

            }

            @Override
            public void onFailure(Call<BusinessDetail> call, Throwable t) {
                Log.i("STUFF","Business Detail Call failed,printing stacktrace...");
                t.printStackTrace();

            }
        });
    }

    private void searchForBusinesses(DataFetcher df)
    {
        int i=0;
        Log.i("FOOD","Inside searchForBusinesses");
        Call<BusinessSearch> bs = df.searchBusinesses("food", mLocation.getLatitude(), mLocation.getLongitude(), 50, true);



        bs.enqueue(new Callback<BusinessSearch>() {
            @Override
            public void onResponse(Call<BusinessSearch> call, Response<BusinessSearch> response) {
                if(response.isSuccessful())
                {
                    Log.i("FOOD","Responsde is successful!1");
                    BusinessSearch bsResponse = response.body();
                    Log.i("FOOD","results returned: "+ bsResponse.getTotal());
                    List<BusinessOverview> businessOverviews =  bsResponse.getBusinesses();
                    for(BusinessOverview b:businessOverviews)
                    {
                        Log.i("FOOD","name: "+b.getName());
                        restIds.add(b.getId());
                    }
                    Log.i("STUFF","Added all "+restIds.size() +" ids");
                    //then pick random 1 and do full search on it
                    //restIds.addAll();
                }
                else
                {
                    Log.i("FOOD","Response found BUT UNSUCCESSFUL, printing stack trace");
                    Log.i("FOOD",response.message()+ " and code is: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<BusinessSearch> call, Throwable t) {
                Log.i("FOOD","Failed to get Respons!");
                Log.i("STUFF","Attempting to print stacktrace");
                t.printStackTrace();
            }
        });
        Log.i("FOOD","Szie is: "+restIds.size());
    }

    private void handlePermissions()
    {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
        {
            // Permission is not granted
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    1);

        }
        getLocation();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        if(requestCode==1)
        {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                getLocation();
            }
        }
            // If request is cancelled, the result arrays are empty.
        else
        {
            Log.i("FOOD","Permission denied!");
            Toast.makeText(MainActivity.this, "location permission denied", Toast.LENGTH_SHORT).show();
        }

    }
}
