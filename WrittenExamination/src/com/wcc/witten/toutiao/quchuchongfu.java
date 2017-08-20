package com.wcc.witten.toutiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by charse on 17-4-18.
 */
public class quchuchongfu {
    public  static  void  main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int count = 0;
        HashMap<Integer, String> hashMap = new HashMap<>();
        while (scanner.hasNext()){
            String  s = scanner.next();
            if(Integer.parseInt(s)==0){
                break;
            }

           if (!hashMap.containsValue(s)){
               hashMap.put(count, s);
               count++;
           }
        }

        System.out.print(hashMap.size());

    }
}
