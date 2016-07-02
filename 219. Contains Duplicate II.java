public class Solution{
    public boolean containsNearbyDuplicate(int[] nums, int k){
        if(nums == null || nums.length == 0) return false;

        Set<Integer> set = new HastSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i - k - 1]);
            if(!set.add(nums[i])) return true;
        }
        return false;       
    }
}