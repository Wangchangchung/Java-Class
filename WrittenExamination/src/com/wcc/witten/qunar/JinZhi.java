package com.wcc.witten.qunar;

import java.util.Scanner;

/**
 * Created by wcc on 01/04/17.
 */
public class JinZhi {


    public  static int charToNumber(String  string){

        if (string == null){
            return 0;
        }
        String  s = string.toLowerCase();
        int n = 0;
        //int j = 0;
        for (int i  = s.length() - 1, j = 1;  i >=0; i--, j*=26){
                if ( s.charAt(i) < 'a' || s.charAt(i) >'z'){
                    return 0;
                }
            n+= ((int)s.charAt(i)-97)*j;
        }
        return  n;
    }

    public  static  void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String  string = null;
        while (scanner.hasNext()){
          string = scanner.nextLine();

        }
        System.out.println(charToNumber(string));
        //String  string = scanner.nextLine();
       // System.out.println(charToNumber(string));
    }
}
