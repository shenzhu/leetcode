// Method One: Use built-in function
public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        Arrays.sort(nums);      // sort array
        return nums[0];
    }
}


// Method Two: Binary search
public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] > nums[nums.length - 1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        
        return nums[left];
    }
}