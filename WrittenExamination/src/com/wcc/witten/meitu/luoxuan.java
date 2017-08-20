package com.wcc.witten.meitu;

import java.util.Scanner;

/**
 * Created by charse on 17-4-16.
 *
 * 美图：  笔试
 *
 * 螺旋打印矩阵
 *
 */
public class luoxuan {

    public  static  void  setMax(int[][] max, int x, int y, int k){
        int start = 1;
        if (x ==y){
            max[x/2][y/2] = x*x;
        }
        for (int d= 0; d < k;d++){
            for (int i = d; i < y- 1-d; i++){
                max[d][i] = start++;
            }
            for (int j = d; j < x-1-d; j++){
                max[j][y-1-d] = start++;
            }
            for (int m = y-1-d; m > d; m--){
                max[x-1-d][m] = start++;
            }
            for (int n = x-1-d; n > d; n--){
                max[n][d] = start++;
            }
        }
    }

    public  static  void setMatrix(int[][] array, int x, int y, int d, int k, int statr ){
        if (d==k){
            if (x==y){
                array[x/2][y/2] = x*x;
            }
            return;
        }

        for (int i = d; i < y-1-d; i++){
            array[d][i] = statr++;
        }

        for (int j = d; j < x-1-d; j++){
            array[j][y-1-d] = statr++;
        }

        for (int m = y-1-d; m > d; m--){
            array[x-1-d][m] = statr++;
        }
        for (int n = x-1-d; n > d; n--){
            array[n][d] = statr++;
        }
        setMatrix(array, x,y, d +1, k, statr);


    }


    public  static  void  main(String[]  args){

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] array = new int[m][n];
        int max = ( m > n )? m : n;
       // setMatrix(array, m, n, 0, max/2, 1);
        setMax(array, m, n, max/2);
        for (int i = 0; i < m ; i++){
            for (int j = 0; j < n; j++){
                System.out.print(array[i][j] +" ");
                //System.out.println(" ");
            }

            System.out.println();
        }


    }
}
