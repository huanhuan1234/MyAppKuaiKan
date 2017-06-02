package bawei.com.myappkuaikan.fragment.fragment3;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import bawei.com.myappkuaikan.R;
import bawei.com.myappkuaikan.adapter.V_xListViewAdapter;
import bawei.com.myappkuaikan.bean.GcBean;
import bawei.com.myappkuaikan.utils.GsonUtil;
import bawei.com.mylibrary.XListView;


/**
 * Created by Administrator on 2017/3/24.
 */

public class V_Fragment extends Fragment {

    private View view;
    private XListView v_xListView;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

        }
    };
    public static V_Fragment getFragment(String path){
        V_Fragment v_Fragment = new V_Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("url",path);
        v_Fragment.setArguments(bundle);
        return v_Fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.view_v_xlist,null);

        initView();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        String  url = (String) bundle.get("url");

        V_AsyncTask v_AsyncTask = new V_AsyncTask();
        v_AsyncTask.execute(url);

        setXListLinstener();
    }

    private void setXListLinstener() {
        v_xListView.setPullRefreshEnable(true);
        v_xListView.setPullLoadEnable(true);
        v_xListView.setXListViewListener(new XListView.IXListViewListener() {
            //下拉刷新
            @Override
            public void onRefresh() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onLoad();
                    }
                }, 2000);

            }

            //上啦加载
            @Override
            public void onLoadMore() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onLoad();
                    }
                }, 2000);
            }
        });
    }

    private void onLoad() {
        v_xListView.stopRefresh();
        v_xListView.stopLoadMore();

        SimpleDateFormat formatter=new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String str =  formatter.format(curDate);
        v_xListView.setRefreshTime(str);
    }

   class V_AsyncTask extends AsyncTask<String,Integer,String>{
       @Override
       protected void onPreExecute() {
           super.onPreExecute();
       }

       @Override
       protected void onPostExecute(String s) {
           super.onPostExecute(s);

           //String s1 = s.toString().trim();
           GcBean bean = GsonUtil.getBean(s, GcBean.class);
           List<GcBean.DataBean.FeedsBean> beanList = bean.getData().getFeeds();

          v_xListView.setAdapter(new V_xListViewAdapter(getActivity(),beanList));

       }

       @Override
       protected void onProgressUpdate(Integer... values) {
           super.onProgressUpdate(values);
       }

       @Override
       protected String doInBackground(String... strings) {
           HttpClient httpClient = new DefaultHttpClient();
           HttpGet httpGet = new HttpGet(strings[0]);
           try {
               HttpResponse response = httpClient.execute(httpGet);
               int code = response.getStatusLine().getStatusCode();
               if (code == HttpStatus.SC_OK){
                   InputStream inputStream = response.getEntity().getContent();
                   ByteArrayOutputStream baos = new ByteArrayOutputStream();
                   int count = 0;
                   byte[] b = new byte[1024];
                   while ((count = inputStream.read(b)) != -1){
                       baos.write(b,0,count);
                   }
                   inputStream.close();
                   baos.close();

                   return new String(baos.toByteArray(),"utf-8");
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
           return null;
       }
   }


    private void initView() {
        v_xListView = (XListView)view.findViewById(R.id.v_xListView);
    }
}
