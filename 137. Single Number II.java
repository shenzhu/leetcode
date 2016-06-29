// Version One
public class Solution{
    public int singleNumber(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int[] bits = new int[32];
        int result = 0;
        for(int i = 0; i < 32; i++){
            for(int j = 0; j < nums.length; j++){
                bits[i] += nums[j] >> i & 1;
            }

            result |= (bits[i] % 3) << i;       // update every digit iteratively   
        }
        return result;
    }
}


// Version Two: Bit Manipulation
public class Solution{
    public int singleNumber(int[] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }

        int one = 0;
        int two = 0;
        int three = 0;

        for(int i = 0; i < nums.length; i++){
            two |= one & nums[i];
            one ^= nums[i];
            three = one & two;
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}