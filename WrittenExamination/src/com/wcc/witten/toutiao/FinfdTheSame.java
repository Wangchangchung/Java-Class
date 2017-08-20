package com.wcc.witten.toutiao;

import java.util.*;

/**
 * Created by charse on 17-4-18.
 */
public class FinfdTheSame {

    public  static ArrayList<Integer> getTheSame(ArrayList<Integer> a, ArrayList<Integer>b){
        ArrayList<Integer>  same = new ArrayList();
        int length = a.size() > b.size() ? b.size():a.size();

        for (int j = 0; j < length; j++){
            if (a.contains(b.get(j))){
                same.add(b.get(j));
            }
        }

        return same;
    }

    public  static  void  main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int count1 = scanner.nextInt();
        ArrayList array1 = new ArrayList(count1);


        for (int i = 0; i < count1; ++i){
            array1.add( Integer.parseInt(scanner.next()));
        }

        int count2 = scanner.nextInt();
        ArrayList array2 = new ArrayList(count2);

        for (int i = 0; i < count2; ++i){
            array2.add( Integer.parseInt(scanner.next()));
        }
       ArrayList<Integer> same = getTheSame(array1, array2);

       for (int i = 0; i < same.size(); ++i){
           if (same.get(i)!= 0){
               System.out.print(same.get(i)+ " ");
           }

       }
    }
}
