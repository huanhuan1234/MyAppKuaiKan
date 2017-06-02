package bawei.com.myappkuaikan.bean;

/**
 * Created by huanhuan on 2017/5/2.
 */

public class UserBean {
    private int image;
    private String message;
    private int imagejian;

    @Override
    public String toString() {
        return "UserBean{" +
                "image=" + image +
                ", message='" + message + '\'' +
                ", imagejian=" + imagejian +
                '}';
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setImagejian(int imagejian) {
        this.imagejian = imagejian;
    }

    public String getMessage() {
        return message;
    }

    public int getImage() {
        return image;
    }

    public int getImagejian() {
        return imagejian;
    }
}
