/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.pappointment;

/**
 *
 * @author vikas
 */
public class Pappointment {
    int id;

    String name;
    String age;
    String sex;
    String address;
    String mobile;
    String email;
    String doctor;
    String symtoms;
    String date;
       int did;
    String image;
    public Pappointment() {
    }

    public Pappointment(String name, String age, String sex, String address, String mobile, String email, String doctor, String symtoms, String date, int did) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.doctor = doctor;
        this.symtoms = symtoms;
        this.date = date;
        this.did = did;
    }
    
    




    public Pappointment(int did, String name, String age, String sex, String address, String mobile, String email, String doctor, String symtoms, String date, String image) {
        this.did = did;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.doctor = doctor;
        this.symtoms = symtoms;
        this.date = date;
        this.image = image;
    }

    public Pappointment(String name, String age, String sex, String address, String mobile, String email, String doctor, String symtoms, String date, String image) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.doctor = doctor;
        this.symtoms = symtoms;
        this.date = date;
        this.image = image;
    }

    public Pappointment(int id, int did, String name, String age, String sex, String address, String mobile, String email, String doctor, String symtoms, String date, String image) {
        this.id = id;
        this.did = did;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.doctor = doctor;
        this.symtoms = symtoms;
        this.date = date;
        this.image = image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSymtoms() {
        return symtoms;
    }

    public void setSymtoms(String symtoms) {
        this.symtoms = symtoms;
    }

    

}
