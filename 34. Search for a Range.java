class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        // initilizing variables
        int flag=0,a=-1,b=-1;
        int numlen=nums.length;
        
        //initially set first number as first and last match
        for (int i=0;i<numlen;i++){
            if (nums[i]==target){ 
                if (flag==0)
                {
                    flag++;
                    a=i;
                    b=i;
                }
                    
                else
                    b=i;
                
            }
                
        }
        int[] arr={a,b}; 
        return (arr);
    }
}
