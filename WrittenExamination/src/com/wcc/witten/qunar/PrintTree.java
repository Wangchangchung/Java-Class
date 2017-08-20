package com.wcc.witten.qunar;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by wcc on 01/04/17.
 */

 class Node{
         Node right;
         Node left;
         int data;

         public Node(int data){
             this.data = data;
         }
}
public class PrintTree {



    public static  Node preAndInToTree(int[] pre, int[] in){
        if (pre == null || in == null){
            return  null;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < in.length; ++i){
            map.put(in[i], i);
        }
        return preIN(pre, 0, pre.length-1, in, 0, in.length-1, map);
    }

    public static  Node preIN(int[] p, int pi, int pj, int[] n, int ni, int nj,
                              HashMap<Integer, Integer> map){
        if (pi > pj){
            return  null;
        }
        Node head = new Node(p[pi]);
        int index = map.get(p[pi]);
        head.left = preIN(p, pi + 1, pi + index -ni, n, ni, index-1,map);
        head.right = preIN(p, pi + index -ni + 1, pj, n, index +1, nj, map);
        return  head;
    }

    public static void printByLeave(Node head){
        if (head ==null){
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        Node last = head;
        Node nLast = null;
        queue.offer(head);
        while (!queue.isEmpty()){
            head = queue.poll();
            System.out.print(head.data + " ");
            if (head.left != null){
                queue.offer(head.left);
                nLast = head.left;
            }
            if (head.right != null){
                queue.offer(head.right);
                nLast = head.right;
            }
            if (head == last && queue.isEmpty()){
                last = nLast;
            }
        }
        System.out.println();

    }



    public static  void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int[] pre = new int[count];
        int[] in = new int[count];

        for (int i = 0; i < count; ++i){
            pre[i] = scanner.nextInt();
        }

        for (int i =0; i < count; ++i){
            in[i] = scanner.nextInt();
        }

        printByLeave(preAndInToTree(pre, in));

    }

}
