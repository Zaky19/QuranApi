package com.example.quranapi.retrofit;

import com.example.quranapi.model.Chapters;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {
    @GET("chapters?language=id")
    Call<Chapters> getSurah();

}
