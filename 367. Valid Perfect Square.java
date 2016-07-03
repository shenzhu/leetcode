// Method One: Linear search
public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 0) return false;
        
        for(int i = 1; i <= num / 2 + 1; i++){
            if(Math.abs(num * 1.0 / i - i) < 0.00000001) return true;
        }
        return false;
    }
}


// Method Two: Binary search
public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 0) return false;
        
        int l = 1;
        int r = num / 2 + 1;
        
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(Math.abs(num * 1.0 / mid - mid) < 0.0000001) return true;
            else if(num * 1.0 / mid > mid) l = mid + 1;
            else r = mid - 1;
        }
        return false;
    }
}