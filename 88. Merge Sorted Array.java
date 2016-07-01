public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Set pointers to end of array
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        // Move elements from end of array
        while(i >= 0 && j >= 0){
            // Move larger element to end of nums1
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
                k--;
            }else{
                nums1[k] = nums2[j];
                j--;
                k--;
            }
        }
        
        // Move remaining elements to nums1, if m > n, no need to move
        while(j >= 0){
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}