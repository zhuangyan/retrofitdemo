package cn.zhuangyan.retrofitdemo.model;

import java.util.List;

/**
 * Created by zhuangyan on 17-3-27.
 */

public class MailListReturn {

    /**
     * count : 14
     * next : null
     * previous : http://10.1.1.102:8080/api/users/?limit=10&name=李
     * results : [{"id":28,"username":"13011100027","realname":"李光光","sex":1,"pinyin":"liguanguan","mobile":"13011100027","post":"经理","business":"经营范围","avatar":"http://10.1.1.102:8080/s/avatar/15111614082910314.jpg","company_name":"荣圆春娱乐宫","industry_id":660000,"lastupdate":1447244146,"is_insider":true,"status":200},{"id":29,"username":"13011100028","realname":"木子李","sex":1,"pinyin":"muzhili","mobile":"13011100028","post":"经理","business":"经营范围","avatar":"http://10.1.1.102:8080/s/avatar/15111614082910313.jpg","company_name":"亚泰隆汽车维修有限公司","industry_id":710000,"lastupdate":1447244146,"is_insider":true,"status":200},{"id":42,"username":"13011100041","realname":"李一","sex":1,"pinyin":"liyi","mobile":"13011100041","post":"经理","business":"经营范围","avatar":"http://10.1.1.102:8080/s/avatar/15111614082910318.jpg","company_name":"四阜机械修造厂","industry_id":520000,"lastupdate":1447244146,"is_insider":true,"status":200}]
     */

    private int count;
    private Object next;
    private String previous;
    private List<ResultsBean> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * id : 28
         * username : 13011100027
         * realname : 李光光
         * sex : 1
         * pinyin : liguanguan
         * mobile : 13011100027
         * post : 经理
         * business : 经营范围
         * avatar : http://10.1.1.102:8080/s/avatar/15111614082910314.jpg
         * company_name : 荣圆春娱乐宫
         * industry_id : 660000
         * lastupdate : 1447244146
         * is_insider : true
         * status : 200
         */

        private int id;
        private String username;
        private String realname;
        private int sex;
        private String pinyin;
        private String mobile;
        private String post;
        private String business;
        private String avatar;
        private String company_name;
        private int industry_id;
        private int lastupdate;
        private boolean is_insider;
        private int status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPost() {
            return post;
        }

        public void setPost(String post) {
            this.post = post;
        }

        public String getBusiness() {
            return business;
        }

        public void setBusiness(String business) {
            this.business = business;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public int getIndustry_id() {
            return industry_id;
        }

        public void setIndustry_id(int industry_id) {
            this.industry_id = industry_id;
        }

        public int getLastupdate() {
            return lastupdate;
        }

        public void setLastupdate(int lastupdate) {
            this.lastupdate = lastupdate;
        }

        public boolean isIs_insider() {
            return is_insider;
        }

        public void setIs_insider(boolean is_insider) {
            this.is_insider = is_insider;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
