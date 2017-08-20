package com.wcc.witten.threzero;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by wcc on 18/03/17.
 */
public class Main {


    public static void getLoactiom(double L, double R){

        double y = Math.sin(-L/R)*R;
        double x = Math.cos(L/R)*R;
        DecimalFormat decimalFormat = new DecimalFormat("0.000");

        System.out.println(decimalFormat.format(x) + " " +decimalFormat.format(y) );
        y = Math.sin(L/R)*R;
        x = Math.cos(L/R)*R;
        System.out.println(decimalFormat.format(x) + " " +decimalFormat.format(y) );
    }
    public static  void main(String[] args){
        //System.out.println("hello");
        Scanner scanner = new Scanner(System.in);
        double l =  scanner.nextDouble();
        double R = scanner.nextDouble();
        getLoactiom(l, R);

    }
}
