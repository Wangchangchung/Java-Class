package com.wcc.witten.ali;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by charse on 17-8-21.
 * 2018年秋招模拟笔试编程题
 *
 * 猴子偷桃子：
 * 猴子下山,有一排桃树, 每次能在一颗树上摘一个桃子,　并且之后要只能在比之前摘的桃树多的树上摘桃子．
 *
 * 那么请问猴子最多只能摘多少个桃子
 * 例如　有５棵桃树　树上的果树是　10 4 5 12 8  那么猴子最多只能摘3个桃子　4 5 8
 *
 */
public class FindTheCountOfPeach{

    public static int getPeachs(int[] peachs){

        int count = 1;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < peachs.length; ++i){
            map.put(peachs[i], i);
        }

        for (int i = 0; i < peachs.length; ++i){
            for (int j = i + 1; j < peachs.length; ++j){
                if (peachs[i] > peachs[j]){
                    int temp = peachs[i];
                    peachs[i] = peachs[j];
                    peachs[j] = temp;
                }
            }
        }

        for (int i= 1; i < peachs.length; ++i){
            if (map.get(peachs[i]) > map.get(peachs[i-1])){
                count++;
            }
        }
        return  count;

    }



    public static  void main(String[] args){

        Scanner in = new Scanner(System.in);
        int count = in.nextInt();

        int[]  peachs = new int[count];

        for (int i =0; i < peachs.length; ++i){
            peachs[i] = in.nextInt();
        }

        System.out.println(getPeachs(peachs));
    }

}
