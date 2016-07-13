public class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for(int i = 1; i < n; i++){
            result = nextString(result);
        }
        return result;
    }
    
    private String nextString(String str){
        StringBuilder sb = new StringBuilder();
        
        // Initialize
        char c = str.charAt(0);
        int count = 1;
        
        // Count and add to sb
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == c){
                count++;
            }else{
                // Add "count and say" of current number to result
                sb.append(count);
                sb.append(c);
                
                // Move to next number
                c = str.charAt(i);
                count = 1;
            }
        }
        
        // Add "count and say" of last number
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }
}