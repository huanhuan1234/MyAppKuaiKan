package bawei.com.myappkuaikan.event;

/**
 * Created by huanhuan on 2017/4/27.
 */

public class ScrollEvent {
    //向上滑动 向上滑动
    public boolean up;
    public ScrollEvent(Boolean up){
        this.up=up;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }
}
