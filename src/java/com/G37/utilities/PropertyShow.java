/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author vikas
 */
public class PropertyShow {
    public void show() throws IOException
    {
Properties pro=new Properties();
InputStream in=getClass().getResourceAsStream("Message.properties");
pro.load(in);
String username=pro.getProperty("username");
String password=pro.getProperty("password");
String url=pro.getProperty("url");
String driver=pro.getProperty("drivername");
System.out.println("my Sql username="+username);
System.out.println("my sql password="+password);
System.out.println("my sql url="+url);
System.out.println("Drivername="+driver);



    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          PropertyShow p=new PropertyShow();
        try{
        p.show();
    }
        catch(Exception e)
        {
           e.printStackTrace();
        }
    }

}
