public class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0) return s;      // corner case
        
        char[] chars = s.toCharArray();
        int length = chars.length;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) sb[i] = new StringBuilder();
        
        int i = 0;
        while(i < length){
            // Vertically down
            for(int idx = 0; idx < numRows && i < length; idx++){
                sb[idx].append(chars[i++]);
            }
            
            // Obliquely up
            for(int idx = numRows - 2; idx >= 1 && i < length; idx--){
                sb[idx].append(chars[i++]);
            }
        }
        
        // Construct whole string
        for(i = 1; i < numRows; i++){
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}