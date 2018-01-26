package com.example.duryab.bb.Models;

/**
 * Created by abc on 1/20/18.
 *
 * @package pk.edu.pucit.mobilecomputing.database.Models
 * @project Database
 */

public class UserLogin {
    private String name;
    private String email;
    private String blood;
    private String phone;
    private int id;
    private String address;

    public UserLogin(int id, String name, String email, String address, String blood, String phone) {
        setId(id);
        setName(name);
        setEmail(email);
        setAddress(address);
        setPhone(phone);
        setBlood(blood);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public String getBlood() {
        return blood;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
