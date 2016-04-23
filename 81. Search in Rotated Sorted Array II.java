public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null) return false;

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while(left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target){
                return true;
            }

            if(nums[left] < nums[mid]){
                if(nums[left] <= target && target <= nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else if(nums[left] > nums[mid]){
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{
                left++;
            }
        }

        return false;
    }
}