package com.sadikali.data.model;

import com.sadikali.data.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sadikali1up on 2016-04-26.
 */
public interface ContactNetworkService {
    @GET("/")
    Call<Results> userData(@Query("page") String page, @Query("results") String results);
}
