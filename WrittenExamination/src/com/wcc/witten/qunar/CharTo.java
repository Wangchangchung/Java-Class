package com.wcc.witten.qunar;

import java.util.*;

/**
 * Created by wcc on 01/04/17.
 */
public class CharTo {


    public  static  int ladderLength(String  start, String  end, ArrayList<String> list){
        if (start.length() == 0  || end.length() ==0){
            return  0;
        }
        //Vector<Vector<String>> result = new Vector<Vector<String>>();

        if (start.length() == end.length() && start.length() ==1){
            return 1;
        }
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        Queue<String> queue  = new LinkedList<String>();
        queue.offer(start);
        list.remove(start);
        count.put(start, 1);

        int minLen = 0x7fffffff;
        Vector<String > curList;

        while (!queue.isEmpty() && list.size() >=0){
            String  curString =queue.element();
            queue.poll();
            int curLen = count.get(curString);
            for (int i = 0;  i < curString.length(); ++i){
                String  temp = curString;
                for (char j= 'a';j <= 'z'; ++j){
                    if (temp.charAt(i) == j){
                        continue;
                    }else {
                        char[] chars = temp.toCharArray();
                        chars[i] = j;
                        temp = chars.toString();
                        if ( temp != list.get(list.size()-1)){
                            queue.offer(temp);
                            count.put(temp, curLen+1);
                            list.remove(temp);
                            if (temp == end){
                                return count.get(temp);
                            }
                        }else  if (temp == end){
                            return  count.get(curString) +1;

                        }
                    }
                }
            }

        }
        return 0;

    }


    public static  void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String  string = scanner.nextLine();
        String  string2 = scanner.nextLine();

        String  list = scanner.nextLine();

        String[] strings = list.split(" ");
        ArrayList<String>  arrayList = new ArrayList<String>();
        for (int i = 0 ; i  <  strings.length; ++i){
            arrayList.add(strings[i]);
        }

        System.out.println(ladderLength(string, string2, arrayList));

    }
}
