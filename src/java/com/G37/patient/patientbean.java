/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.patient;

/**
 *
 * @author vikas
 */
public class patientbean {

    int id;
    String username;
   String password;
   String name;
   String address;
   String mobile;
   String email;

    public patientbean() {
    }

    public patientbean(String username, String password, String name, String address, String mobile, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
    }

    public patientbean(int id, String username, String password, String name, String address, String mobile, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
