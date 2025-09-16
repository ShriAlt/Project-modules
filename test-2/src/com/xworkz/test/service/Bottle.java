package com.xworkz.test.service;

public class Bottle {

    public  Bottle(){
        System.out.println("no args of Bottle");
    }


    public void isExist(boolean yes ){
        System.out.println("yes it exists ");
    }

    public String  isExist(String yes){
        return "yes";
    }
}
