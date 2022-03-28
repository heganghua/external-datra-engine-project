package com.jxzj.external.data.designmode.buildmode;

public class Home {

    private String province; // 省

    private String city;

    private String town;

    public Home(String province, String city, String town) {
        super();
        this.province = province;
        this.city = city;
        this.town = town;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getTown() {
        return town;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "Home [province=" + province + ", city=" + city + ", town=" + town + "]";
    }

}
