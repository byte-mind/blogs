package code;

import java.lang.System;
import java.util.LinkedList;

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
    public static int[] rorateArray(int [] nums, int K){
        int[] ret = new int [nums.length];

        for(int i=0; i< nums.length; i++){
            int new_position = (i + K) % nums.length; // using "mod" to do Cyclic Rotation           
            ret[new_position] = nums[i]; // put A[i] to the new position
        }
        return ret;
    }


    public static void main(String [] args) {
       
        // System.out.println(solution("amz","amz"));
        System.out.println(solution("abc","bcd"));

        // System.out.println(binaryGap(20));
        // System.out.println(binaryGap(529));
        // System.out.println(binaryGap(15));
        // System.out.println(binaryGap(32));
    }

}