package bawei.com.myappkuaikan.task;

import android.os.AsyncTask;
import android.text.TextUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import bawei.com.myappkuaikan.utils.StreamUtils;

/**
 * Created by huanhuan on 2017/4/25.
 */

public class IAsyncTak extends AsyncTask<Object,Void,String> {
    private ResponesListener reaponesListener;
    private String result;
    private InputStream is;

    public IAsyncTak(ResponesListener reaponesListener){
        this.reaponesListener=reaponesListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Object... params) {
        String result="";
        String path= (String) params[0];
        if (TextUtils.isEmpty(path)){
            return result;
        }
        try {
            URL url=new URL(path);
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            if (conn.getResponseCode()==200){
                is = conn.getInputStream();
                result = StreamUtils.inputStream(is);

                System.out.println("---result---" + result);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
                try {
                if (is!=null) {
                    is.close();
                    is = null;
                }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return result;
            }

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        System.out.println("---s----" + s);
        if (reaponesListener!=null){
            if (TextUtils.isEmpty(s)){
                reaponesListener.onFail();
            }else {
                reaponesListener.sussess(s);
            }
        }else {
            reaponesListener.onFail();
        }
    }
}
