// Method One: Sum
public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int sumAll = n * (n + 1) / 2;
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        
        return sumAll - sum;
    }
}


// Method Two: Bit Manipulation
public int missingNumber(int[] nums) {

    int xor = 0, i = 0;
    for (i = 0; i < nums.length; i++) {
        xor = xor ^ i ^ nums[i];
    }

    return xor ^ i;
}


// Method Three: Binary Search
public int missingNumber(int[] nums) { //binary search
    Arrays.sort(nums);
    int left = 0, right = nums.length, mid= (left + right)/2;
    while(left<right){
        mid = (left + right)/2;
        if(nums[mid]>mid) right = mid;
        else left = mid+1;
    }
    return left;
}