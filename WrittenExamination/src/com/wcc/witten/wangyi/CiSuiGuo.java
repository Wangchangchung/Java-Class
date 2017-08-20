package com.wcc.witten.wangyi;

import java.util.Scanner;

/**
 * Created by charse on 17-8-12.
 */
public class CiSuiGuo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x = in.nextInt();
        int f = in.nextInt();
        int d = in.nextInt();
        int p = in.nextInt();
        System.out.println(getDays(x,f,d,p));


        //System.out.println("x :" + x + "f:" +f + "d:" + d +"p:"+ p);
        // 3 5 100 10
    }



    public static int  getDays(int x, int f, int d, int p){

        int days = 0;
        int fanzu = 0;
        if ( x < 1 || f < 1 || d < 1 || p < 1){
            return  0;
        }
        if (d < x ){
            return 0;
        }
        while (true) {
            //System.out.println("day：" + days);
            //System.out.println("总价："+ d);
            //System.out.println("现在话费:" + fanzu);
            if (days < f) {
                 fanzu += x;
                if (fanzu <= d) {
                    days++;
                }else {
                    return  days;
                }
            }else{
                 fanzu += (x + p);
                if (fanzu <=d){
                    days++;
                }else {
                    return  days;
                }
            }
        }
    }
}
