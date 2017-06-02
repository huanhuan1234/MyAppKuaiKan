package bawei.com.myappkuaikan.utils;

import com.google.gson.Gson;


/**
 * Created by Administrator on 2017/3/16.
 */

public class GsonUtil {
    //将json数据封装成对象
    public static <T>T getBean(String jsonstr, Class<T> cla){
        Gson gson = new Gson();
        T bean = gson.fromJson(jsonstr, cla);
        return bean;
    }
    //将对象-->json串
    public static String getDataByBean(Class clas){
        Gson gson = new Gson();
        String str = gson.toJson(clas);
        return str;
    }
}
