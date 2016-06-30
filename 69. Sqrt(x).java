// Method One: Binary search
public class Solution {
    public int mySqrt(int x) {
        if(x < 0) return x;
        
        // Use binary search to find square root
        int left = 1;
        int right = x / 2 + 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(x / mid == mid) return mid;
            else if(x / mid > mid) left = mid + 1;
            else right = mid - 1;
        }
        
        return right;
    }
}


// Method Two: Newton's method
public class Solution {
    public int mySqrt(int x) {
        if(x < 0) return x;
        
        double last = 0;
        double res = 1;
        while(res != last){
            last = res;
            res = (res + x / res) / 2;
        }
        return int(res);
    }
}

