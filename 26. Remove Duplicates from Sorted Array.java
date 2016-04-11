public class Solution {
    public int removeDuplicates(int[] nums) {
        //extreme situation
        if(nums == null) return 0;
        
        int index = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[index] != nums[i]){
                index++;
                nums[index] = nums[i];
            }
        }
        
        return index + 1;
    }
}