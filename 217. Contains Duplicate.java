// Version One: HashSet
public class Solution{
    public boolean containsDuplicate(int[] nums){
        // Corner case
        if(nums == null || nums.length == 0){
            return false;
        }

        Set<Integer> set = new HashSet<Integer>();
        for(int x : nums){
            if(set.contains(x)) return true;
            else set.add(x);
        }

        return false;
    }
}


// Version Two:
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
}