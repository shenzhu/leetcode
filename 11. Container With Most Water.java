public class Solution{
    public int maxArea(int[] height){
        if(height == null || height.length == 0) return 0;

        // Set two pointers at both ends of array
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while(left < right){
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) 
                      * (right - left));        // update max value
            
            // Move pointers
            if(height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }
}