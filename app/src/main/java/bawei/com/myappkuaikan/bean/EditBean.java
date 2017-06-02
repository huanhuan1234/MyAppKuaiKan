package bawei.com.myappkuaikan.bean;

/**
 * Created by huanhuan on 2017/5/2.
 */

public class EditBean {

    private int id;
    private String phone;
    private String password;

    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "EditBean{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
