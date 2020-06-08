package com.pack.diplomap.MapObjects;

import java.io.Serializable;

public class RoomInfo implements Serializable
{
    private static final long serialVersionUID = -1315152605557457796L;
    int number;
    String name;
    String description;
    String site;
    String telephone;

    public RoomInfo()
    {
         number=0;
         name="";
         description="";
         site="";
         telephone="";
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


}
