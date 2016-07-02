public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //construct result
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        //check extreme situation
        if(nums == null || nums.length < 4) return result;

        //sort array
        Arrays.sort(nums);

        int pfront;
        int pback;
        int complement;

        for(int i = 0; i < nums.length - 3; i++){
            //avoid duplicate
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length - 2; j++){
                //avoid duplicate. Attention: Here j is > i + 1, not > 0, or when nums = {0, 0, 0, 0}, it will jump
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                //set pointers
                pfront = j + 1;
                pback = nums.length - 1;
                complement = target - nums[i] - nums[j];
                while(pfront < pback){
                    if(nums[pfront] + nums[pback] == complement){
                        //construct answer and add to result
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[pfront], nums[pback]);
                        result.add(list);

                        //move pointers
                        while(pfront < pback && nums[pfront] == nums[pfront + 1]) pfront++;
                        while(pfront < pback && nums[pback] == nums[pback - 1]) pback--;
                        pfront++;
                        pback--;
                    }else if(nums[pfront] + nums[pback] < complement){
                        pfront++;
                    }else{
                        pback--;
                    }
                }
            }
        }
        return result;
    }
}