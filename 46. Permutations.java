// Version One: Iteratively add element
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        // Corner case
        if(nums == null || nums.length == 0){
            return result;
        }        
    
        // Init
        List<Integer> l0 = new ArrayList<Integer>();
        l0.add(nums[0]);
        result.add(l0);
        
        for(int i = 1; i < nums.length; i++){
            List<List<Integer>> temp_result = new ArrayList<List<Integer>>();       // temp result
            
            // Add new item to current lists
            for(int j = 0; j <= i; j++){
                for(List<Integer> l : result){
                    List<Integer> temp_list = new ArrayList<Integer>(l);
                    temp_list.add(j, nums[i]);
                    temp_result.add(temp_list);
                }
            }
            result = temp_result;
        }
        
        return result;
    }
}


// Version Two: Lexicographical order
public class Solution{
    public int factorial(int n){
        return (n == 1 || n == 0) ? 1 : factorial(n - 1) * n;
    }

    public void reverse(List<Integer> list, int begin, int end){
        for(int i = begin, j = end; i < j; i++){
            list.add(i, list.remove(j));
        }
    }
    
    // Use lexicographical order method to find next permutation
    public List<Integer> nextPermutation(List<Integer> nums){
        // Find last ascending order
        int i = nums.size() - 1;
        while(i > 0 && nums.get(i - 1) >= nums.get(i)){
            i--;
        }

        // Find last number larger than nums[i - 1]
        int j = i;
        while(j < nums.size() && nums.get(j) > nums.get(i - 1)){
            j++;
        }

        // Swap nums[i - 1] and nums[j - 1]
        int temp = nums.get(i - 1);
        nums.set(i - 1, nums.get(j - 1));
        nums.set(j - 1, temp);

        // Reverse numbers after i
        reverse(nums, i, nums.size() - 1);

        List<Integer> result = new ArrayList<Integer>();
        result.addAll(nums);
        return result;
    } 

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        // Corner case
        if(nums == null || nums.length == 0){
            return result;
        }

        int length = nums.length;
        Arrays.sort(nums);      // lexicographical order requires ascending order sort

        // Convert array to list
        List<Integer> list0 = new ArrayList<Integer>();
        for(int i = 0; i < length; i++){
            list0.add(nums[i]);
        }

        List<Integer> l1 = new ArrayList<Integer>();
        l1.addAll(list0);
        result.add(l1);

        // Find next permutation
        for(int i = 1; i < factorial(length); i++){
            result.add(nextPermutation(list0));
        }
        return result;
    }
}