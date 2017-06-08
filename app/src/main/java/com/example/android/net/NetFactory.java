package com.example.android.net;

/**
 * Created by YC on 2017/6/8.
 *
 */

public class NetFactory {

    private static final int VOLLEY = 1;
    private static final int RETROFIT = 2;
    private static final int TYPE = RETROFIT;
    private static IHttp getInstance(){
        IHttp http = null;
        switch (TYPE){
            case VOLLEY:
                break;
            case RETROFIT:
                break;
        }
        return http;
    }

}
