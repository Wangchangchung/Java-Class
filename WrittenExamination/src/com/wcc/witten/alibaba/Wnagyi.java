package com.wcc.witten.alibaba;

import java.util.Scanner;

/**
 * Created by wcc on 25/03/17.
 */
public class Wnagyi {
    public static int getConut(String string){

        int count = 0;
        if (string.length() == 2){
            return  0;
        }

        for (int i = 0; i < string.length(); ++i){
            if (string.charAt(i) == 'G'){
                for (int j = i- 1; j >= 0; j--){
                    if (string.charAt(j) == 'B'){
                        count++;
                    }
                }
            }
        }
        return  count;

    }


    public static  int  dasjs(String  string){
        int i = 0;
        int j = string.length()- 1;
        int temp =0 ;
        while (i < j){
            while (i < j && string.charAt(i) == 'G'){
                i++;
            }
            while (i < j && string.charAt(i) == 'B'){
                j--;
            }
            if (i < j){
                temp++;
            }
        }
        return  temp;

    }



    public static  void main(String[] args){
        //String  string = "GGBBG";
        //System.out.println(getConut(string));
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        System.out.println(dasjs(string));

    }
}
