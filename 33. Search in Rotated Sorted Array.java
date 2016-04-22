/* Linear Traversal */
public class Solution {
    public int search(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }
}

/* Modified Binary Search */
public class Solution {
    public int search(int[] nums, int target) {
        //extreme situation
        if(nums == null) return -1;

        int l = 0;
        int r = nums.length - 1;

        //binary search
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[l] <= nums[mid]){
                //target is in the left part of situation 2
                if(nums[l] <= target && target <= nums[mid]){
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }else{
                //target is in the right part of situation 3
                if(nums[mid] <= target && target <= nums[r]){
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}