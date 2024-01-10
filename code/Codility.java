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

    public int frogJump(int X, int Y, int D){
        int count = 1;

        while(true){

            if (X + D * count >= Y){
                break;
            }
            count++;
        }

        return count;
    }

    @Test
    public void testFrogJump(){
        System.out.println(frogJump(10, 85, 30));
    }


    @Test
    public void testPermMissingElem(){

    }



    public int tapeEquilibrium(int [] nums){
        int minDiff = 10;
        int right = 0 , left = 0;

        for( int i = 0; i < nums.length ; i++){

            right+= nums[i];
            left = leftSum(nums, i + 1);
            if(Math.abs(right - left) <= minDiff){
                minDiff = Math.abs(right - left);
            }

        }

        return minDiff;
    }
    public int leftSum(int [] nums , int pos){
        int leftSum = 0;
        for( int i = nums.length - 1; i >= pos; i--){
            leftSum+= nums[i];
        }
        return leftSum;
    }

    @Test
    public void testTapeEquilibrium(){
        System.out.println(tapeEquilibrium(new int[]{ 3,1,2,4,3 }));

    }


    public int countMod(int A, int B, int K){
        int count = 0;
        int i = A;

        while(i <= B){

            if( i % K == 0){
                count++;
            }
            i++;
        }

        return count;
    }

    @Test
    public void testCountMod(){
        System.out.println(countMod(4, 11, 2));
    }
}
