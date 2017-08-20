package com.wcc.common;

/**
 * Created by charse on 17-4-23.
 */
public class IngterAndInt{


    public  static  void  Str(){

        System.out.println("this is test Method");
    }

    public static void main(String[] args){
        int  i = 1;
        Integer  j = new Integer(1);
        System.out.println(i==j);
        System.out.println(j.equals(i));

        ((IngterAndInt)null).Str();
    }
}
