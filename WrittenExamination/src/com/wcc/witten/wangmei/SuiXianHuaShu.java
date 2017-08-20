package com.wcc.witten.wangmei;

import java.util.Scanner;

/**
 * Created by WCC on 2017/3/8.
 */
public class SuiXianHuaShu {
    public static  void  judegShuiXianHua(int begin, int end){

        boolean flag = false;
        for( int i = begin ; i <= end; ++i){
            int ge = i%10;
           // System.out.println(ge);
            int shi = (i/10)%10;
            //System.out.println(shi);
            int bai = (i/100)%10;
            //System.out.println(bai);
           // System.out.println();
            if (i == Math.pow(ge,3) + Math.pow(shi,3) + Math.pow(bai, 3)){
                System.out.println(i + " ");
                flag  = true;
            }
        }
        if (!flag){
            System.out.println("no");
        }
    }

    public static  void  main(String[] args){
        judegShuiXianHua(100, 120);

    }
    /**

     Scanner scanner = new Scanner(System.in);
     int begin = scanner.nextInt();
     int end = scanner.nextInt();
     boolean flag = false;
     for( int i = begin ; i <= end; ++i){
     int ge = i%10;
     // System.out.println(ge);
     int shi = (i/10)%10;
     //System.out.println(shi);
     int bai = (i/100)%10;
     //System.out.println(bai);
     // System.out.println();
     if (i == Math.pow(ge,3) + Math.pow(shi,3) + Math.pow(bai, 3)){
     System.out.println(i + " ");
     flag  = true;
     }
     }
     if (!flag){
     System.out.println("no");
     }

     */
}
