package cn.zhuangyan.retrofitdemo.model;

/**
 * Created by zhuangyan on 17-3-24.
 */

public class LoginReturn {
    /**
     * token :
     * user_id :
     * realname :
     * is_insider : true
     * avatar :
     */

    private String token;
    private String user_id;
    private String realname;
    private boolean is_insider;
    private String avatar;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public boolean isIs_insider() {
        return is_insider;
    }

    public void setIs_insider(boolean is_insider) {
        this.is_insider = is_insider;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
