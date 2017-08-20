package com.wcc.witten.toutiao;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by charse on 17-4-18.
 */
public class geshishuchu {
    /*

  *    ***   ***   * *   ***   ***   ***   ***   ***   ***
  *      *     *   * *   *     *       *   * *   * *   * *
  *    ***   ***   ***   ***   ***     *   ***   ***   * *
  *    *       *     *     *   * *     *   * *     *   * *
  *    ***   ***     *   ***   ***     *   ***   ***   ***
  *
   *        * *    *   ****
  ***  ***   *    *
   *        * *  *     ****   **
                              **
     */




    public  static  void  main(String[] args){

        String[] arr = new String[]{
                "***\n" +"* *\n"+"* *\n"+"* *\n"+"***",
          "*\n" +"*\n" +
                  "*\n" +
                  "*\n" +
                  "*",

                "***" +"\n  *\n"+"***\n"+"*  \n"+"***",

                "***" +"\n  *\n"+"***\n"+"  *\n"+"***",

                "* *\n" +"* *\n"+"***\n"+"  *\n"+"  *",

                "***\n" +"*  \n"+"***\n"+"  *\n"+"***",

                "***\n" +"*  \n"+"***\n"+"* *\n"+"***",

                "***\n" +"  *\n" +
                        "  *\n" +
                        "  *\n" +
                        "  *",


                "***\n" +"* *\n"+"***\n"+"* *\n"+"***",

                "***\n" +"* *\n"+"***\n"+"  *\n"+"***"




        };



        String[]  op = new String[]{
                " * \n"+"***\n" + " * ",
                "   \n" + "***\n" +"   ",
                "* *\n" +" * \n"+"* *",
                "  *\n" + " * \n" +"*  ",
                "****\n" +"    \n" +"****",
                "  \n" +"  \n"+"**\n"+"**"
        };

        //for (int i = 0; i < arr.length; i++ ){
          //  System.out.println(arr[i]);
       // }
       // for (int i = 0; i < op.length; i++ ){
        //    System.out.println(op[i]);
       //     System.out.println();
      //  }
        Scanner scanner = new Scanner(System.in);

        String st =  scanner.nextLine();
        getCount(st, arr, op);



    }

    public static  void  getCount(String  string, String[] a, String[] b){


        ArrayList<Character> shu = new ArrayList<>();
        ArrayList<Character> op = new ArrayList<>();
        shu.add('0');
        shu.add('1');
        shu.add('2');
        shu.add('3');
        shu.add('4');
        shu.add('5');
        shu.add('6');
        shu.add('7');
        shu.add('8');
        shu.add('9');
        op.add('+');
        op.add('-');
        op.add('*');
        op.add('/');
        op.add('.');

        for (int i = 0 ; i < string.length(); i++){
            if (shu.contains(string.charAt(i))){
                //shu.indexOf(string.charAt(i));
                System.out.print(a[shu.indexOf(string.charAt(i))]);
            }else if (op.contains(string.charAt(i))){
                System.out.print(b[op.indexOf(string.charAt(i))]);
            }
        }

    }


}
