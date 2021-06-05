package models;

import javax.xml.crypto.Data;

public class Userinfo {
    private  int id;
    private Data createtime;
    private Data updatetime;
    private String username;
    private String password;
    private  int state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Data getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Data createtime) {
        this.createtime = createtime;
    }

    public Data getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Data updatetime) {
        this.updatetime = updatetime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
