// Method One
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int length = s.length();
        int i = length - 1;
        int j;
        
        // Jump ' ' in the end of String
        while(i >= 0 && s.charAt(i) == ' ') i--;
        j = i;
        
        while(j >= 0 && s.charAt(j) != ' ') j--;        // count chars
        
        if(i < 0) return i + 1;
        else return i - j;
    }
}


// Method Two:
public class Solution{
    public int lengthOfLastWord(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }
}