package com.ncu.chygienicjavaweb.entity;

public class UserInformation {
    private String name;
    private int sex;
    private String school;
    private String career;
    private String identity;
    private String phone;
    private String account;

    public UserInformation
            (String name, int sex, String school, String career,
             String identity, String phone, String account) {
        this.name = name;
        this.sex = sex;
        this.school = school;
        this.career = career;
        this.identity = identity;
        this.phone = phone;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
