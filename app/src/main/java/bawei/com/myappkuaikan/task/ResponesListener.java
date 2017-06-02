package bawei.com.myappkuaikan.task;

/**
 * Created by huanhuan on 2017/4/25.
 */

//网络请求的回调方法
public interface ResponesListener {
    //成功会跳的方法
    public void sussess(String string);
    //失败会跳的方法
    public void onFail();

}
