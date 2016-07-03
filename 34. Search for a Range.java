public class Solution{
    public int[] searchRange(int[] nums, int target){
        int i = 0;
        int j = nums.length - 1;
        int[] result = {-1, -1};

        // Search for left range
        while(i < j){
            int mid = (i + j) / 2;
            if(nums[mid] < target) i = mid + 1;
            else j = mid;
        }
        if(nums[i] != target) return result;
        else result[0] = i;

        // Search for right range
        j = nums.length - 1;        // do not need to set i to i this time
        while(i < j){
            int mid = (i + j) / 2 + 1;      // make mid biased to the right
            if(nums[mid] > target) j = mid - 1;
            else i = mid;
        }
        if(nums[j] != target) return result;
        else result[1] = j;
        return result;

    }
}