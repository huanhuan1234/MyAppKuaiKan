package bawei.com.myappkuaikan.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by huanhuan on 2017/4/25.
 */

public class StreamUtils {
    public static String inputStream(InputStream is){
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer=new byte[1024];
        int len=0;
        try {
            while ((len=is.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
            is.close();
            bos.close();
            return bos.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
