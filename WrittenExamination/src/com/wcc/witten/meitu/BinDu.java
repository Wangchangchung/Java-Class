package com.wcc.witten.meitu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by charse on 17-4-16.
 */
public class BinDu {

    public static  int getCount(ArrayList<String> list, int n){

        return  0;
    }

    public  static void  main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int n = scanner.nextInt();
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < count; i++){
            String  str =  scanner.next();
            list.add(str);
        }
    }
}
