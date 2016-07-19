// Method One
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0) return 0;
        
        int moveNumber = 0;
        while(m < n){
            m >>= 1;
            n >>= 1;
            moveNumber++;
        }
        
        return m << moveNumber;
    }
}


// Method Two:
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0) return 0;
        
        while(m < n){
            n &= (n - 1);
        }
        
        return n;
    }
}