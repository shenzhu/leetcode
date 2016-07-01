public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        
        if(nums == null || nums.length == 0) return result;
        
        int number1 = nums[0];
        int number2 = nums[0];
        
        int count1 = 0;
        int count2 = 0;
        
        int length = nums.length;
        
        // Find two majority numbers 
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == number1){
                count1++;
            }else if(nums[i] == number2){
                count2++;
            }else if(count1 == 0){
                number1 = nums[i];
                count1++;
            }else if(count2 == 0){
                number2 = nums[i];
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        
        // Find the frequency of two nunbers found above
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == number1){
                count1++;
            }else if(nums[i] == number2){
                count2++;
            }
        }
        
        if(count1 > length / 3) result.add(number1);
        if(count2 > length / 3) result.add(number2);
        return result;
    }
}