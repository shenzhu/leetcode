// Method One
public class Solution{
    public void sortColors(int[] nums){
        int r = 0;
        int w = 0;
        int b = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) r++;
            else if(nums[i] == 1) w++;
            else b++;
        }

        for(int i = 0; i < nums.length; i++){
            if(i < r) nums[i] = 0;
            else if(i < r + w) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}


// Method Two
public class Solution{
    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public void sortColors(int[] nums){
        int n = nums.length;   
        int r = 0;
        int b = 0;
        
        for(int i = 0; i < n - b; i++){
            // Red
            if(nums[i] == 0){
                swap(nums, i, r);
                r++;
            // Blue
            }else if(nums[i] == 2){
                swap(nums, i, n - 1 - b);
                b++;
                i--;
            }
        }
    }
}