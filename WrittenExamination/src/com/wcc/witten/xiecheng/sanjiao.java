package com.wcc.witten.xiecheng;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by charse on 17-4-27.
 */
public class sanjiao {

    public  static  double getLen(int[] a, int[] j){
        return   Math.sqrt((a[1]-j[1])*(a[1]-j[1]) +(a[2]-j[2])*(a[2]-j[2])  + (a[3]-j[3])*(a[3]-j[3]));
    }

    public static   double getMax(int[][] ar){


        double  max = 0.0;
        for (int i = 0; i < ar.length; i++){
            for (int j = i+1; j < ar.length; j++){
                if (ar[i][0] == ar[j][0]){
                    for (int k = j + 1; k < ar.length; k++){
                        if (ar[i][0] == ar[k][0]){
                             double a = getLen(ar[i], ar[j]);
                             double b  = getLen(ar[i], ar[k]);
                             double c = getLen(ar[j], ar[k]);
                             double  p = (a + b + c)/2;
                             double  l = Math.sqrt(p*(p-a)*(p-b)*(p-c));
                             if (l - max > 0){
                                 max = l;
                             }

                        }
                    }
                }
            }
        }

        for (int i = 0; i < ar.length; i++){
            for (int j = i+1; j < ar.length; j++){
                if (ar[i][0] != ar[j][0]){
                    for (int k = j + 1; k < ar.length; k++){
                        if (ar[i][0] != ar[k][0] && ar[j][0] != ar[k][0]){
                            double a = getLen(ar[i], ar[j]);
                            double b  = getLen(ar[i], ar[k]);
                            double c = getLen(ar[j], ar[k]);
                            double  p = (a + b + c)/2;
                            double  l = Math.sqrt(p*(p-a)*(p-b)*(p-c));
                            if (l - max > 0){
                                max = l;
                            }

                        }
                    }
                }
            }
        }
        return  max;

    }

    public  static  void  main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[][] array = new int[count][4];

        for (int i = 0; i < count; i++){
            for (int j =0; j < 4; j++){
                String  s = scanner.next();
                if (s.equals("R")){
                    array[i][0] = -1;
                    //System.out.println("--");
                   continue;
                }else if (s.equals("B")){
                    array[i][0] =-2;
                   continue;
                }else if (s.equals("G")){
                    array[i][0] = -3;
                    continue;
                }else{
                    array[i][j] = Integer.parseInt(s);
                }

            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.00000");


        System.out.println(decimalFormat.format(getMax(array)));
    }
}
