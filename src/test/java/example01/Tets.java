package example01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tets {

    public static void main(String[] args) {
        int[] nums = new int[] {1};
        Solution solution = new Solution(nums);
        int pick = solution.pick(1);
        System.out.println(pick);
    }
}



class Solution {

    public int[] nums;
    public static final Random RA = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        List<Integer> indexs = new ArrayList<Integer>();
        for(int index = 0 ;index < nums.length;index ++){
            int num = nums[index];
            if(num == target){
                indexs.add(index);
            }
        }
        return indexs.get(RA.nextInt(indexs.size()));
    }
}