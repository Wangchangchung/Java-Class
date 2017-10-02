package com.wcc.witten.yidongtuya;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by charse on 17-9-7.
 *
 * 给定一字符串，只包含数字,请写一个算法，找出该字符串中的最长的不重复子串
 * (不重复是指子串中每个元素不同于子串中其它元素)
 * 120135435  201354
 */
public class FindTheMaxLengthUiqueStr {

    public  static void maxUnique(String str){
        if (str==null || "".equals(str)){
            return ;
        }
        //用于保存无重复字串
        Set<String> set = new TreeSet();
        char[] chars = str.toCharArray();
        //申请大小为10的数组,index表示0-9的数,
        //数组值代表为该数最近一次出现的位置下标, 一开始初始化为-1
        int[] arr = new int[10];
        for (int i = 0 ; i < 10; ++i){
            arr[i] = -1;
        }

        int len = 0; //无重复字串的最长长度
        int pre = -1; //遍历到当前节点i时,在i-1结尾下最长无重复子串开始的前一个位置
        int cur = 0;

        for (int i = 0; i != chars.length; ++i){
            //数组值不为-1,前面出现过该字符,则pre+1 - i位置
            // 为无重复字符,截取保存
            if(arr[Integer.parseInt(chars[i]+"")] != -1){
                set.add(str.substring(pre +1, i));
            }

            pre = Math.max(pre, arr[Integer.parseInt(chars[i]+"")]);
            cur = i - pre;
            len = Math.max(len, cur);

            //保存该字符在str最进出现的下标
            arr[Integer.parseInt(chars[i]+"")] = i;
        }

        for (String s: set) {
            if (len == s.length()){
                System.out.println(s);
            }
        }
    }

    public  static void main(String[] args){

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        //String　str = "120135435";
        maxUnique(str);
    }
}
