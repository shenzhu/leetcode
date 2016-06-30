// Method One: Sort
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}


// Method Two: Moore Voting Algorithm
public class Solution{
    public int majorityElement(int[] nums){
        int candidate = 0;
        int count = 0

        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                candidate = nums[i];
                count = 1;
            }else{
                if(nums[i] == candidate){
                    count++
                }else{
                    count--;
                }
            }
        }
        return candidate;
    }
}