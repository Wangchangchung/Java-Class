package com.wcc.witten;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by charse on 17-4-27.
 */
public class baidu {


    public  static  int  Quic(int[] array, int k){
        int min = array[0];
        int index = 1;
        for (int i = 1; i < array.length; i++){
            if (array[i]>min){
                min = array[i];
                index++;
            }
            if (index == k){
                return array[i];
            }
        }
        return  -1;

    }


    public  static  void main(String[] args){


        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] array = new int[count];

        for (int i= 0 ; i < count; i++){
            array[i] = Integer.parseInt(scanner.next());
        }

        System.out.println(Quic(array, 3));


    }

}
