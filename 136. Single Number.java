public class Solution{
    public int singleNumber(int[] nums){
        // Corner case
        if(nums == null || nums.length == 0){
            return 0;
        }

        int rest = 0;
        for(int i = 0; i < nums.length; i++){
            rest ^= nums[i];
        }

        return rest;
    }
}