package bawei.com.myappkuaikan.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import bawei.com.myappkuaikan.R;
import bawei.com.myappkuaikan.task.IAsyncTak;

/**
 * Created by huanhuan on 2017/4/25.
 */

public class BaseActivity extends FragmentActivity {
    //把串型改成并行
    private static final int KEEP_ALIVE_SECONDS = 30;
    private static final BlockingQueue<Runnable> sPoolWorkQueue =
            new LinkedBlockingQueue<Runnable>(128);
    public static  ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            3, 10, KEEP_ALIVE_SECONDS, TimeUnit.SECONDS,
            sPoolWorkQueue);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

    }
}
