package com.example.android.net;

import java.util.Map;

/**
 * Created by YC on 2017/6/8.
 *
 */

public interface IHttp {

    void GET(String url, Map<String, String> map, MyCallBack callBack);
    void GETS(String url, Map<String, String> map, MyCallBack callBack);
    void POST(String url, Map<String, String> map, MyCallBack callBack);

}
