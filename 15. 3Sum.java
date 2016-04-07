/* Brute Force */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        resultList.add(list);
                    }
                }
            }
        }
        return resultList;
    }
}

/* Find Complement */
public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        //sort array
        java.util.Arrays.sort(nums);
        
        //find complement
        int complement;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                complement = 0 - nums[i] - nums[j];
                
                int index = java.util.Arrays.binarySearch(nums, complement);
                if(index >= 0 && nums[index] > nums[j]){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[index]);
                    
                    if(!result.contains(list)){
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }


/* Thid Method */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int pfront;
        int pback;
        
        //sort array
        java.util.Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            int complement = 0 - nums[i];
            
            //set pointers
            pfront = i + 1;
            pback = nums.length - 1;
            
            //search complement
            while(pfront < pback){
                if(nums[pfront] + nums[pback] == complement){
                    //construct answer, nondescending order
                    List<Integer> list = java.util.Arrays.asList(nums[i], nums[pfront], nums[pback]);
                    if(!result.contains(list)){
                        result.add(list);
                    }
                    
                    /*
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[pfront]);
                    list.add(nums[pback]);
                    result.add(list);
                    */
                    
                    //move pointers and avoid duplicate 
                    pfront++;
                    pback--;
                    
                }else if(nums[pfront] + nums[pback] < complement){
                    pfront++;
                }else{
                    pback--;
                }
            }
        }
        return result;
    }
}

/* Fourth Method */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        //Attention: alaways consider extreme situation
        if(nums == null || nums.length < 3) return result;
        
        int pfront;
        int pback;
        int complement;
        
        //sort array
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++){
            //avoid duplicate
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            
            complement = 0 - nums[i];
            //set pointers
            pfront = i + 1;
            pback = nums.length - 1;
            
            while(pfront < pback){
                if(nums[pfront] + nums[pback] == complement){
                    List<Integer> list = Arrays.asList(nums[i], nums[pfront], nums[pback]);
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
        return result;
    }
}