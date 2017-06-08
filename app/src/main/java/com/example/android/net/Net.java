package com.example.android.net;

import java.util.Map;

/**
 * Created by YC on 2017/6/8.
 *
 */

public interface Net {

    void get(String url, Map<String, String> map, MyCallBack callBack);
    void gets(String url, Map<String, String> map, MyCallBack callBack);
    void post(String url, Map<String, String> map, MyCallBack callBack);

}
