package com.wcc.witten.ali;

import java.util.Scanner;

/**
 * Created by charse on 17-4-26.
 */
public class Main {


    public  static  int filter(String str,  String  pattern){

       // System.out.println(pattern.indexOf('*'));

        // * 在中间
        if (pattern.indexOf('*') > 0){
            for (int i=0; i < str.length(); i++){

                if (pattern.charAt(i) == '?'){
                    continue;
                }
                if (pattern.charAt(i) == '*'){
                    return 1;
                }

                if (str.charAt(i) != pattern.charAt(i)){
                     return 0;
                }
            }
        // *在最前
        }else {


            if (str.indexOf(pattern.substring(1, pattern.length()-1)) !=-1){
                return  1;
            }else {
                return  0;
            }

        }


        return -1;
    }


    public static  void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println();

        System.out.println(filter("100-trade-done","*trade-done"));


    }
}
