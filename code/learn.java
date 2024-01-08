package code;

import java.lang.System;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;

import javax.xml.transform.Source;

public class learn {
    
    static class Node {

        public Node next;
        public int val;

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    public static Node reverse( Node input) {
        Node reverse = new Node(0, null);

        

        return reverse;
    }

    // 我们有两个字符串P和Q，每个字符串由N个小写英文字母组成。对于字符串中的每个位置，
    // 我们必须从P或Q中选择一个字母，以构造一个新字符串S，使得S中不同字母的数量最小。我们的任务是找到结果字符串S中不同字母的最小数量。
    // 例如，如果P =“ca”且Q =“ab”，则S可以等于：“ca”，“cb”，“aa”或“ab”。字符串“aa”只有一个不同的字母（‘a’），因此答案为1（在这些字符串中最小）。
    public static int solution(String P, String Q) {
        int[] freq = new int[26];
        for (int i = 0; i < P.length (); i++) {
            freq [P.charAt (i) - 'a']++;
        }
        for (int i = 0; i < Q.length (); i++) {
            freq [Q.charAt (i) - 'a']--;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                count++;
            }
        }
        return count++;
    }

    // 20 10100
    public static int binaryGap(int N){

        int longest = 0;
        if (N == 1)
            return 0;
        char [] arrs = Integer.toBinaryString(N).toCharArray();

        for( int i = 0; i < arrs.length; i++){

            if (arrs[i] == '1'){
                int j = i+1;
                int count = 0;

                while(j < arrs.length) {
                    if(arrs[j] == '1'){
                        longest = longest > count ? longest : count;
                        i = j;
                        count = 0;
                    } else {
                        count++;
                    }
                    j++;
                }
                break;
            }
        }

        return longest;

    }




    // https://github.com/Anfany/Codility-Lessons-By-Python3/blob/master/L2_Arrays/2.1%20CyclicRotation.md
    // https://github.com/Mickey0521/Codility/blob/master/CyclicRotation.java
    // https://chienchikao.blogspot.com/2017/08/codility-lesson-2-arrays-2.html
    // https://zihengcat.github.io/2019/08/31/leetcode-189-rotate-array/
    public static int[] rotateArray(int [] nums, int K){
        int[] ret = new int [nums.length];

        for(int i=0; i< nums.length; i++){
            int new_position = (i + K) % nums.length; // using "mod" to do Cyclic Rotation           
            ret[new_position] = nums[i]; // put A[i] to the new position
        }
        return ret;
    }

    public static int[] rotateArray1(int [] nums, int K){
       
        for(int i = 0; i < K; i++){
            int tmp = nums[nums.length - 1];
            shiftArray(nums);
            nums[0] = tmp;
        }
        return nums;
    }

    public static int [] shiftArray (int [] nums){
        for(int i = nums.length - 1; i > 0; i--){
            nums[i] = nums[i-1];
        }
        return nums;
    }


// https://chienchikao.blogspot.com/2017/08/2-add-two-numbers.html

    public static Node addTwoNum( Node A, Node B){

        Node head = new Node(0, null);
        int carry = 0;
        while(A.next != null && B.next != null){
                int tmp = A.val + B.val + carry;
                if (tmp > 10) {
                    head.val = tmp % 10;
                    carry = tmp / 10;
                } else {
                    head.val = tmp + carry;
                }
                head.next = new Node(0, null);
                head = head.next;
                A = A.next;
                B = B.next;
        }
        return head;

    }
    public static int longestSubstring(String s){
        int longest = 0;
        char[] arrs = s.toCharArray();
        int len = arrs.length;
        final HashSet keys = new HashSet();
        int i = 0, j = i+1;
        while(i < len && j<len-1){

        }
        return longest = longest > keys.size() ? longest : keys.size();
    }


    public static Node add(){

        Node A = new Node(1, new Node(2, new Node(3, new Node(4, null))));

        Node B  = new Node(1, new Node(3, new Node(4, new Node(5, null))));

        Node head = new Node(0, null);

        Node tmp = null;

        while(A.next != null && B.next != null){

            if(A.val > B.val){
                head.val = B.val;
                B = B.next;
            } else {
                head.val=A.val;
                A = A.next;
            }
            tmp = new Node(0, null);
            head.next = tmp;
        }

        return head;
    }


    public static void main(String [] args) {
       
        Node h = add();
        System.out.println(h);


        // int nums [] = {1,2,3,4}; 
        // int ret [] = rotateArray( nums, 1);
        // System.out.println(Arrays.toString(ret));
        // System.out.println(solution("amz","amz"));
        // System.out.println(solution("abc","bcd"));

        // System.out.println(binaryGap(20));
        // System.out.println(binaryGap(529));
        // System.out.println(binaryGap(15));
        // System.out.println(binaryGap(32));
    }

}