public class Solution {
    public void reverse(int[] nums, int begin, int end){
        // Corner case
        if(nums == null || nums.length == 0){
            return;
        }
        
        int l = begin;
        int r = end;
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
    
    public void nextPermutation(int[] nums) {
        // Corner case
        if(nums == null || nums.length == 0){
            return;
        }
        
        // Find the last ascending position
        int position = -1;
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] > nums[i - 1]){
                position = i - 1;
                break;
            }
        }
        
        // If ascending order does not exists, reverse nums
        if(position < 0){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        // If ascending order exists, find the last element larger than nums[position] 
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] > nums[position]){
                int temp = nums[i];
                nums[i] = nums[position];
                nums[position] = temp;
                break;
            }
        }
        
        // Reverse number after position
        reverse(nums, position + 1, nums.length - 1);
    }
}