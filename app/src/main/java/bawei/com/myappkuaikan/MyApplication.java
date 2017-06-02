package bawei.com.myappkuaikan;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by huanhuan on 2017/4/28.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration
                .createDefault(this);
        //Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(configuration);



    }




    public  static DisplayImageOptions getOption(){
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher) // resource or drawable
                .showImageForEmptyUri(R.drawable.ic_empty) // resource or drawable
                .showImageOnFail(R.drawable.ic_error) // resource or drawable
                .delayBeforeLoading(1000)
                .cacheInMemory(true) // default
                .cacheOnDisk(true) // default
                .build();
        return  options;
    }
}
