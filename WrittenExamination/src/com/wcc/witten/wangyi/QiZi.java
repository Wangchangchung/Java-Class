package com.wcc.witten.wangyi;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by charse on 17-8-12.
 */
public class QiZi {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int cont = in.nextInt();
        int arrX[] =new int[cont];
        int arrY[] = new int[cont];

        for (int i = 0; i < cont; ++i){
            arrX[i] = in.nextInt();
        }

        for (int y = 0; y < cont; ++y) {
            arrY[y] = in.nextInt();
        }
        //System.out.println(arrX[3]);
        //System.out.println(arrY[3]);
        Stack  stack = new Stack();
        //stack.push()

    }

    public static  void  getSteps(int[] arrX, int[] arrY, int count){

        for (int i = 0 , j = i+1; i < arrX.length-1; i++){
            if (arrX[i] == arrX[j]){
                System.out.println(Math.abs(arrY[i]- arrY[j]));
            }else if (arrY[i] == arrY[j]){
                System.out.println(Math.abs(arrY[i]- arrY[j]));
            }else {

            }
        }
    }
}
