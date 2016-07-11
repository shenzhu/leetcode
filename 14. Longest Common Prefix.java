public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";       // corner case
        
        String pre = strs[0];
        for(int i = 1; i < strs.length; i++){
            // Reduce pre until have sth in common
            while(strs[i].indexOf(pre) != 0){
                pre = pre.substring(0, pre.length() - 1);
                if(pre.isEmpty()) return "";
            }
        }
        
        return pre;
    }
}