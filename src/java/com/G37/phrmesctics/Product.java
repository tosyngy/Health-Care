/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.phrmesctics;

/**
 *
 * @author vikas
 */
public class Product {
    int pid;
    String pname;
    float p_price;
    int stockinhand;
    int dangerlevel;

    public Product() {
    }

    public Product(String pname, float p_price, int stockinhand, int dangerlevel) {
        this.pname = pname;
        this.p_price = p_price;
        this.stockinhand = stockinhand;
        this.dangerlevel = dangerlevel;
    }

    public Product(int pid, String pname, float p_price, int stockinhand, int dangerlevel) {
        this.pid = pid;
        this.pname = pname;
        this.p_price = p_price;
        this.stockinhand = stockinhand;
        this.dangerlevel = dangerlevel;
    }

    public int getDangerlevel() {
        return dangerlevel;
    }

    public void setDangerlevel(int dangerlevel) {
        this.dangerlevel = dangerlevel;
    }

    public float getP_price() {
        return p_price;
    }

    public void setP_price(float p_price) {
        this.p_price = p_price;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getStockinhand() {
        return stockinhand;
    }

    public void setStockinhand(int stockinhand) {
        this.stockinhand = stockinhand;
    }



}
