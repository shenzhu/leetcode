public class Solution{
    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public int factorial(int x){
        return (x == 0) || (x == 1) ? 1 : factorial(x - 1) * x;
    }
    
    public void nextPermutation(int[] nums){
        int i = nums.length - 1;
        while(i > 0 && nums[i] <= nums[i - 1]){
            i--;
        }
        if(i <= 0) return;

        int j = nums.length - 1;
        while(j >= i && nums[j] <= nums[i - 1]){
            j--;
        }

        int temp = nums[i - 1];
        nums[i - 1] = nums[j];
        nums[j] = temp;

        int l = i;
        int r = nums.length - 1;
        while(l < r){
            temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }

        List<Integer> list = new ArrayList<Integer>();
        for(int x : nums){
            list.add(x);
        }
        result.add(list);
    }
    
    public List<List<Integer>> permuteUnique(int[] nums){
        // Corner case
        if(nums == null || nums.length == 0){
            return result;
        }

        // Sort nums
        Arrays.sort(nums);
        
        // Convert nums to list
        List<Integer> list = new ArrayList<Integer>();
        for(int x : nums){
            list.add(x);
        }
        result.add(list);

        // Add next permutation iterativel
        for(int i = 1; i < factorial(nums.length); i++){
            nextPermutation(nums);
        }

        return result;
    }
}