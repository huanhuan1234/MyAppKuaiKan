package bawei.com.myappkuaikan.utils;

/**
 * Created by Administrator on 2017/4/28 0028.
 */

public class UrlUtils {
    /**
     * 周一：http://api.kkmh.com/v1/daily/comic_lists/0?
     * since=0&gender=0&sa_event=
     */

    private static String host_url = "http://api.kkmh.com/v1/daily/comic_lists/";
    private static String another = "?since=0&gender=0&sa_event=eyJwcm9qZWN0Ijoia3VhaWthbl9hcHAiLCJ0aW1lIjoxNDg3ODI5MTE2OTEyLCJwcm9wZXJ0aWVzIjp7IkhvbWVwYWdlVGFiTmFtZSI6IueDremXqCIsIlZDb21tdW5pdHlUYWJOYW1lIjoi54Ot6ZeoIiwiJG9zX3ZlcnNpb24iOiI0LjIuMiIsIkdlbmRlclR5cGUiOiLlpbPniYgiLCJGcm9tSG9tZXBhZ2VUYWJOYW1lIjoi54Ot6ZeoIiwiJGxpYl92ZXJzaW9uIjoiMS42LjM0IiwiJG5ldHdvcmtfdHlwZSI6IldJRkkiLCIkd2lmaSI6dHJ1ZSwiJG1hbnVmYWN0dXJlciI6InNhbXN1bmciLCJGcm9tSG9tZXBhZ2VVcGRhdGVEYXRlIjo2LCIkc2NyZWVuX2hlaWdodCI6NTc2LCJIb21lcGFnZVVwZGF0ZURhdGUiOjUsIlByb3BlcnR5RXZlbnQiOiJSZWFkSG9tZVBhZ2UiLCJGaW5kVGFiTmFtZSI6IuaOqOiNkCIsImFidGVzdF9ncm91cCI6NDYsIiRzY3JlZW5fd2lkdGgiOjEwMjQsIiRvcyI6IkFuZHJvaWQiLCJUcmlnZ2VyUGFnZSI6IkhvbWVQYWdlIiwiJGNhcnJpZXIiOiJDTUNDIiwiJG1vZGVsIjoiR1QtUDUyMTAiLCIkYXBwX3ZlcnNpb24iOiIzLjguMSJ9LCJ0eXBlIjoidHJhY2siLCJkaXN0aW5jdF9pZCI6IkE6OTA1MTA0Mjc2Mzc1NTEwOSIsIm9yaWdpbmFsX2lkIjoiQTo5MDUxMDQyNzYzNzU1MTA5IiwiZXZlbnQiOiJSZWFkSG9tZVBhZ2UifQ%3D%3D";
    /**
     * 得到week 的地址
     */
    public static String getUrl(long week) {
        String url = host_url + week + another;
        return url;
    }
}
