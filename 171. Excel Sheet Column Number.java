public class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) return 0;
        
        char[] chars = s.toCharArray();
        int result = 0;
        
        for(Character c : chars){
            result = result * 26 + (int)(c - 'A') + 1;
        }
        
        return result;
    }
}