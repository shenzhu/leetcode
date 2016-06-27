// While checking
public class Solution {
    public boolean isPowerOfTwo(int n) {
        // Corner cases
        if(n == 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        
        int power = 1;
        while(power <= n){
            if(power == n){
                return true;
            }
            
            power *= 2;
        }
        
        return false;
    }
}

// Bit Manipulation
public class Solution{
	public boolean isPowerOfTwo(int n){
		return ((n > 0) && (n & (n - 1) == 0));
	}
}