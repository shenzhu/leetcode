/* HashMap */
public class Solution {
    public int removeDuplicates(int[] nums) {
        //extreme situation
        if(nums == null) return 0;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        //init HashMap
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.replace(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
        }
        
        int index = 0;
        for(int i = 1; i < nums.length; i++){
            if(map.get(nums[i]) <= 2){
                index++;
                nums[index] = nums[i];
            }else{
                //update HashMap
                map.replace(nums[i], map.get(nums[i]) - 1);
            }
        }
        
        return index + 1;
    }
}

/* Element Compare */
public class Solution {
    public int removeDuplicates(int[] nums) {
        //extreme situation
        if(nums == null) return 0;
        if(nums.length < 2) return nums.length;
        
        int index = 2;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[index - 2]){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}