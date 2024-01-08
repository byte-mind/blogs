package code;


import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import junit.*;


public class Codility {
    
    public int binaryGap(int N) {
        int maxCount = 0;
        int count = 0;
        char [ ] arrs = Integer.toBinaryString(N).toCharArray();
        boolean started = false;
        for(int i = 0 ; i < arrs.length; i++){
            // meet the first 1
            if(started){

                if(arrs[i] == '1'){
                    started = false;
                    maxCount = Math.max(maxCount, count);
                    break;    
                }else {
                    count++;
                }
            } else {
                if(arrs[i] == '1'){
                    started = true;
                }
            }
        }
        return maxCount;
    }

    @Test
    public void testBinaryGap(){

        System.out.println(binaryGap(9));
        System.out.println(binaryGap(529));
        System.out.println(binaryGap(15));
    }


    public int [] CyclicRotation(int [] nums, int K){

        for(int k = 0; k < K; k++){


            int last = nums[nums.length - 1];

            for( int i = nums.length - 1; i > 0 ; i--){

                nums[i] = nums[i-1];
            }
            nums[0] = last;
        }

        return nums;

    }

    @Test
    public void testCycleArray(){
        // 9,7,6,3,8
        System.out.println(CyclicRotation(new int [] {3,8,9,7,6}, 3));
    }


    public Set<Integer> oddOccurance(int [] nums){
        Set<Integer> ret = new HashSet<Integer>();

        for(int i = 0; i < nums.length ; i++){

            if(ret.contains(nums[i])){
                ret.remove(nums[i]);
            }else{

                ret.add(nums[i]);
            }

        }
        return ret;
    }

    @Test
    public void testOddOccurance(){
        Set<Integer> ret = oddOccurance(new int[] {9,3,9,3,9,7,9});
        for (Integer integer : ret) {
            System.out.println(integer);
        }
    }

}
