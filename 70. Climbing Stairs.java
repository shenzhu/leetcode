public class Solution {
    public int climbStairs(int n) {
        if(n <= 1){
            return 1;
        }
        
        // Initialize
        int last = 1;
        int lastlast = 1;
        int now = 0;
        
        // Function
        for(int i = 2; i <= n; i++){
            now = last + lastlast;
            lastlast = last;
            last = now;
        }
        
        return last;
    }
}