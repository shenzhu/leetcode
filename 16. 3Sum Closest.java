public class Solution {
    public int threeSumClosest(int[] nums, int target) {
         //sort array
         Arrays.sort(nums);
         
         int result = 0;
         int pfront;
         int pback;
         //max value 
         int diff = Integer.MAX_VALUE;
         
         for(int i = 0; i < nums.length - 2; i++){
             //set pointers
             pfront = i + 1;
             pback = nums.length - 1;
             
             while(pfront < pback){
                 int sum = nums[i] + nums[pfront] + nums[pback];
                 if(sum == target){
                     return target;
                 }else if(Math.abs(target - sum) < diff){
                     //update closest value and diff
                     diff = Math.abs(target - sum);
                     result = sum;
                 }
                 
                 //move pointers
                 if(sum < target){
                     pfront++;
                 }else{
                     pback--;
                 }
             }
         }
         return result;
    }
}