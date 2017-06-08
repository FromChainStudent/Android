package com.example.android.net;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by YC on 2017/6/8.
 *
 */

public interface RetrofitNet {

    @GET
    Call<Response> get();

}
