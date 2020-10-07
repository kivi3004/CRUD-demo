
package com.database;

public class Emp {
    private int id;
    private String name, password, email, country;
    public void setID(int id){
        this.id=id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPassword(String pass){
        password = pass;
    }
    public void setEmail(String mail){
        email = mail;
    }
    public void setCountry(String cntry){
        country = cntry;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return email;
    }
    public String getCountry(){
        return country;
    }

    
    
}
