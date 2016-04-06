/* Method One */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        
        for(int i = 0; i < nums.length; ++i){
            for(int j = i + 1; j < nums.length; ++j){
                if(nums[i] + nums[j] == target){
                    //construct result
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}


/* Method Two */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        //init hashmap
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        
        //find the complement 
        int complement;
        for(int i = 0; i < nums.length; i++){
            complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No such numbers");
    }
}


/* Method Three */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int complement;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        //find and store in one iteration
        for(int i = 0; i < nums.length; i++){
            //find
            complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            
            //store
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No such numbers");
    }
}