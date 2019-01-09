/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.labadmin;

/**
 *
 * @author vikas
 */
public class record {

    int id;
    int pid;
    int did;
    String name;
    int age;
    String sex;
    String test;
    String report;
    String date;
    String remark;
    int aid;
    String doctor;
    String mobile;

    public record() {
    }

    public record(int id, int pid, int did, String name, int age, String sex, String test, String report, String date, String remark, int aid, String doctor, String mobile) {
        this.id = id;
        this.pid = pid;
        this.did = did;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.test = test;
        this.report = report;
        this.date = date;
        this.remark = remark;
        this.aid = aid;
        this.doctor = doctor;
        this.mobile = mobile;
    }

    public record(String name, int age, String sex, String test, String report, String date, String remark, int aid, String doctor, String mobile) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.test = test;
        this.report = report;
        this.date = date;
        this.remark = remark;
        this.aid = aid;
        this.doctor = doctor;
        this.mobile = mobile;
    }




    public record(int did, int pid, String name, int age, String sex, String test, String report, String date, String remark, int aid, String doctor, String mobile) {
        this.pid = pid;
        this.did = did;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.test = test;
        this.report = report;
        this.date = date;
        this.remark = remark;
        this.aid = aid;
        this.doctor = doctor;
        this.mobile = mobile;
    }

    public record(int did, String name, int age, String sex, String test, String report, String date, String remark, int aid, String doctor, String mobile) {
        this.did = did;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.test = test;
        this.report = report;
        this.date = date;
        this.remark = remark;
        this.aid = aid;
        this.doctor = doctor;
        this.mobile = mobile;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
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

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    
}
