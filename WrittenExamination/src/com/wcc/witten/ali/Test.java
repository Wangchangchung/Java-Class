package com.wcc.witten.ali;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class Test{

    public  static String   operator = "^+*";

    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            Double res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }






    // write your code here
    public static Double resolve(String expr) {

        LinkedBlockingQueue blockingQueue =  new LinkedBlockingQueue<String>();
        StringBuffer temp = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        stack.setSize(16);

        for (int i= 0; i < expr.length(); i++){
            char c = expr.charAt(i);
            if (operator.indexOf(c) >=0){
                if (temp.length() > 0){
                    blockingQueue.offer(temp.toString());
                    temp = new StringBuffer();
                    if (stack.size() > 0){
                        stack.push(c);
                    }else {
                        while (stack.size() > 0){
                            char op1 = stack.lastElement();
                            int com = opcompare(op1, c);
                            if (com <=0){
                                blockingQueue.offer(String.valueOf(stack.pop()) );
                            }else {
                                stack.push(c);
                                break;
                            }

                        }

                        if (stack.size() ==0){
                            stack.push(c);
                        }
                        break;
                    }
                }else {
                   temp.append(c);

                }
            }
        }
        if (temp.length() > 0){
            blockingQueue.offer(temp.toString());
        }

        while (stack.size() > 0){
            blockingQueue.offer(String.valueOf(stack.pop()));
        }
        return caltueWithQueue(blockingQueue);

    }

    //
    public  static  int opcompare(char op1, char op2){
        if (op1 == '*'){
            if (op2 =='^'){
                return  1;
            }
        }
        if (op1=='-'){
            if (op2== '^' ){
                return 1;
            }
        }

        if (op1 =='^'){
            return  -1;
        }

        return  0;

    }


    public static  double caltueWithQueue(Queue<String> queue){
        Stack<Double> stack = new Stack<>();
        while (true){
            String  s = queue.poll();
            if (s ==null){
                break;
            }
            if (operator.indexOf(s) > 0){

                double num1 = stack.pop();

                double num2 = stack.pop();
                double sum = 0;
                switch (s.charAt(0)){
                    case '+':
                        sum = num1 + num2;
                        break;
                    case '^':
                        sum = num1++;
                        break;
                    case '*':
                        sum = num1*num2;
                        break;
                }
            }else {
                stack.push(Double.valueOf(s));
            }
        }
        return  stack.pop();
    }
}