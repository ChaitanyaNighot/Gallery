package com.example.chaitnya.gallery.ui;

/**
 * Created by hites on 12/9/2016.
 */

public class Dept  {

    private  String name;
    private  int deptID;

    public Dept(String name,int deptID)
    {
        this.setName(name);
        this.setDeptID(deptID);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDeptID() {
        return deptID;
    }

    public void setDeptID(int deptID) {
        this.deptID = deptID;
    }
}
