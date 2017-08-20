package com.wcc.witten.alibaba;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by wcc on 25/03/17.
 */
public class dache {

    public  static  void  minTiem(){

    }
    public  static  void  main(String[] args){
        Scanner scanner = new Scanner(System.in);
         int count = scanner.nextInt();
        HashMap<Integer, int[]> map = new HashMap<Integer, int[]>();
         for (int i = 0; i < count; i++){
             int[] a = {};
             a[0] = scanner.nextInt();
             a[1] =  scanner.nextInt();
             map.put(1, a);
         }

        //Proxy
        InvocationHandler d;


    }
}
