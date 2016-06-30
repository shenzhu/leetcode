public class Solution {
    public int reverse(int x) {
        int result = 0;
        
        boolean negative = false;
        if(x < 0){
            negative = true;
            x = -x;
        }
        
        while(x != 0){
            // Check if result overflows
            if(result > (Integer.MAX_VALUE - x % 10) / 10){
                return 0;
            }else{
                result = result * 10 + x % 10;
            }
            x /= 10;
        }
        
        return negative ? -result : result;
    }
}