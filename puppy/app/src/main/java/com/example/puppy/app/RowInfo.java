package com.example.puppy.app;

/**
 * Created by shaojin on 16/05/14.
 */
public class RowInfo {
    private String id;
    private String name;
    private String email;
    private String address;
    private String gender;
    private String mobilePhone;
    private String homePhone;
    private String officePhone;

    public RowInfo(String id, String name, String email, String address, String gender, String mobilePhone, String homePhone, String officePhone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.mobilePhone=mobilePhone;
        this.homePhone =homePhone;
        this.officePhone=officePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    public String getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
