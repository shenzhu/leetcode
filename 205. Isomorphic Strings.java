public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sMap = new int[256];
        int[] tMap = new int[256];
        int n = s.length();
        
        for(int i = 0; i < n; i++){
            if(sMap[s.charAt(i)] != tMap[t.charAt(i)]) return false;
            sMap[s.charAt(i)] = i + 1;
            tMap[t.charAt(i)] = i + 1;
        }
        
        return true;
    }
}