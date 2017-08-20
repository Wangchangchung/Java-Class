package com.wcc.witten.baicizhan;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by WCC on 2017/3/13.
 * 百词斩
 *
 */
public class Shudu {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer,int[]> map = new HashMap<Integer, int[]>();
        int count = 0;
        int begin = 0;
        int end = 0;
        count = scanner.nextInt();
        for(int i = 0; i < count ;i++){
            int a[] = new int[3];
            a[0]= scanner.nextInt();
            a[1]= scanner.nextInt();
            a[2]= scanner.nextInt();
            map.put(i, a);
        }

        begin = scanner.nextInt();
        end = scanner.nextInt();
        double time = computeTime(map, begin, end);
        System.out.println("所用总时间：" + time);
    }

    private static double computeTime(HashMap<Integer, int[]> map, int begin, int end) {
        int index = 0;
        int tail = 0;
        for (index = 0; index < map.size(); ++index){
            if (map.get(index)[0] <= begin){
               // System.out.println(index +"index");
                break;
            }
        }
        for (tail = 0; tail < map.size(); tail++){
            if (map.get(tail)[1] >= end){
               // System.out.println(tail+"tail");
                break;
            }
        }
        if (index == tail || map.get(index)[1] == begin && map.get(tail)[1] == end){
            return  (end-begin)/(double)map.get(tail)[2];
        }
        int temp = begin;
        double time = 0;
        for(; index < tail; index++){
            double n = ((map.get(index)[1]- temp)/ (double)(map.get(index)[2]));
            time += n;
            temp = map.get(index)[1];
        }
     //   System.out.println("time"+ time );
        double p = (map.get(tail)[1]-end)/(double)map.get(tail)[2];
     //   System.out.println("p" + p);
        return  time + p;
    }
    /**
     * 4
     0 30 10
     30 40 20
     40 80 20
     80 100 5
     20 60

     4
     0 30 30
     30 50 20
     50 80 30
     80 100 20
     30 60

     */
}
