package com.pawan.esoftwarica.RecycleView;

public class Softwarica {
    private String name;
    private int age;
    private String address;
    private String gender;
    private int imgProfileId;
    private int imgRemoveId;

    public Softwarica(String name, int age, String address, String gender, int imgProfileId, int imgRemoveId) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.imgProfileId = imgProfileId;
        this.imgRemoveId = imgRemoveId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getImgProfileId() {
        return imgProfileId;
    }

    public void setImgProfileId(int imgProfileId) {
        this.imgProfileId = imgProfileId;
    }

    public int getImgRemoveId() {
        return imgRemoveId;
    }

    public void setImgRemoveId(int imgRemoveId) {
        this.imgRemoveId = imgRemoveId;
    }
}

