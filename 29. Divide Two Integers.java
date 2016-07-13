public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;     // corner case
        
        // Handle overflow
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)){
            return Integer.MAX_VALUE;
        }
        
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        int result = 0;
        
        // Iteratively dvs * 2 and subtract it from dvd
        while(dvd >= dvs){
            long temp = dvs;
            int multiple = 1;
            while(dvd >= (temp << 1)){
                multiple <<= 1;      // record # of dvs 
                temp <<= 1;      // temp * 2
            }
            dvd -= temp;
            result += multiple;
        }
        
        return sign < 0 ? -result : result;
    }
}