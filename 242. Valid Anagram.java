// Method One: Hash
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;

        if(s.length() != t.length()) return false;

        int[] alphabet = new int[26];
        for(int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
        for(int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
        for(int i : alphabet) if(i != 0) return false;
        return true;
    }
}


// Method Two: Sort
public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    char[] str1 = s.toCharArray();
    char[] str2 = t.toCharArray();
    Arrays.sort(str1);
    Arrays.sort(str2);
    return Arrays.equals(str1, str2);
}