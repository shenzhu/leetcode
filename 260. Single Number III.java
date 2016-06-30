public class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        
        int[] result = new int[2];
        int xor = 0;
        
        for(int i = 0; i < nums.length; i++){
            xor ^= nums[i];
        }
        
        // Find the last digit == 0, and divides nums according to it
        int lastBit = xor - (xor & (xor - 1));
        int group0 = 0;
        int group1 = 0;
        
        for(int i = 0; i < nums.length; i++){
            if((lastBit & nums[i]) != 0){
                group1 ^= nums[i];
            }else{
                group0 ^= nums[i];
            }
        }
        
        // Construct result
        result[0] = group0;
        result[1] = group1;
        return result;
    }
}