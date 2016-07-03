// Method One: Loop and Flip
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int result = 0;
        
        while(n != 0){
            result += n & 1;
            n >>>= 1;
        }
        
        return result;
    }
}


// Method Two: Bit Manipulation Trick
public class Solution{
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }
}
