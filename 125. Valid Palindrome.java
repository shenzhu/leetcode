public class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        
        int head = 0;
        int tail = s.length() - 1;
        int cHead;
        int cTail;
        
        while(head < tail){
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            
            if(!Character.isLetterOrDigit(cHead)){
                head++;
                continue;
            }
            if(!Character.isLetterOrDigit(cTail)){
                tail--;
                continue;
            }
            if(Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) return false;
            head++;
            tail--;
        }
        
        return true;
    }
}