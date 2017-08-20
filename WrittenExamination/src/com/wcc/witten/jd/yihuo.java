package com.wcc.witten.jd;

import java.util.Scanner;

/**
 * Created by charse on 17-4-7.
 */
public class yihuo {

    public  static  int getNumber(String string1,String string2, int count){
        int sum = 0;
        for (int i = count,j = 0; i >= 0; --i, j++){

            if (string1.charAt(i) != string2.charAt(i)){
                sum += Math.pow(2,j);
            }
        }
        return  sum;
    }


    public static  void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int count =  scanner.nextInt();

        String str1 = scanner.next();
       // System.out.println(str1);

        String str2 = scanner.next();
       // System.out.println(str2);



        //s2 = str2.toCharArray();
        System.out.println(getNumber(str1, str2,  count-1));

    }
}
