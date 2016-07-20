public class Solution {
    class stringComp implements Comparator<String>{
        @Override
        public int compare(String str1, String str2){
            String s1 = str1 + str2;
            String s2 = str2 + str1;
            return s2.compareTo(s1);
        }
    }
    
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) return "";
        
        // Convert int to String
        String[] numsString = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            numsString[i] = String.valueOf(nums[i]);
        }
        
        // Sort String based on self-defined rull
        Arrays.sort(numsString, new stringComp());
        
        // An extreme corner case by lc, say you have only a bunch of 0 in your int array
        if(numsString[0].charAt(0) == '0') return "0";
        
        // Construct answer
        StringBuilder sb = new StringBuilder();
        for(String s : numsString){
            sb.append(s);
        }
        return sb.toString();
    }
}