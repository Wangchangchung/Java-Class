package com.wcc.witten.wangmei;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by WCC on 2017/3/8.
 */
public class ShuxLieQiuHe{

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double m;
        double n;
        double sum = 0;
        while (scanner.hasNext()){
            m = scanner.nextInt();
            n = scanner.nextInt();
            for(int i = 0; i < n; ++i){
                sum = sum + m;
                m = Math.sqrt(m);
            }
            System.out.printf("%.2f", sum);
            System.out.println();
        }
    }
}
