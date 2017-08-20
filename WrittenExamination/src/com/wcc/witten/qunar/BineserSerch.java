package com.wcc.witten.qunar;

/**
 * Created by charse on 17-4-15.
 */
public class BineserSerch {

    public  static  int  bineraSearch(int[] array, int target){
        int mid =0;
        int head = 0;
        int tail = array.length -1;

        while (head <= tail){
            // 如果使用的是 (tail + head)/2 的化是当tail 和 和head 数据量很大的时候
            // 是会产生溢出的现象，所以的化是不能使用这个的
            mid = head + (tail - head)/2;
            if (array[mid] > target){
                tail = mid-1;
            }else if (array[mid] < target){
                head = mid+1;
            }else {
                return  mid;
            }
        }
        return  -1;
    }


    public  static  void  main(String[] args){
        int[] a1= {1,2,3,4,5,6,7,8};
        //int[] a2 = {98,87,56,43,32,12};
        System.out.println(bineraSearch(a1,3));
       // System.out.println(bineraSearch(a2,32));
    }

}
