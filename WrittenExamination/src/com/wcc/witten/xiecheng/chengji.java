
package com.wcc.witten.xiecheng;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by charse on 17-4-11.
 */
public class chengji {


    /**
     *  一个数 分解成
     * @param args
     */


    public static  void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        BigInteger bigInteger = new BigInteger("1");
        int n = scanner.nextInt();
        int a[]=  new int[3000];
        int sum = 2;
        a[0] = 2;
        int i = 1;
        int j = 0;
        while (true){
            a[i] = a[i-1]+1;
            if (sum+a[i] > n){
                break;
            }else {
                sum += a[i];
            }
            i++;
        }

        a[i]= n-sum;
        j = i-1;
        while (a[i] != 0 && j >=0){
            a[j]++;
            a[i]--;
            j--;
        }
        j = i-1;

        while (a[i]!=0 && j >= 0){
            a[j]++;
            a[i]--;
            j--;
        }
        for (int k = 0; k < i-1; k++){
            System.out.println(a[k]+"");
            bigInteger= bigInteger.multiply(BigInteger.valueOf(a[k]));
        }
        System.out.println(a[i-1]);
        bigInteger = bigInteger.multiply(BigInteger.valueOf(a[i-1]));
        System.out.println(bigInteger.toString());
    }
}
