// 与数学相关的题目要先思考下，看看能否发现规律，不要一上来就开始胡乱写程序
// 记住对一个数的每个位进行求平方和的方法
public class Solution {
    public int digitSqure(int n){
        int sum = 0;
        
        while(n != 0){
            sum += Math.pow(n % 10, 2);
            n /= 10;
        }
        
        return sum;
    }
    
    public boolean isHappy(int n) {
        // corner case
        if(n < 1) return false;
        if(n == 1) return true;
        
        int sum = n;
        HashSet hashset = new HashSet();
        
        while(true){
            if(hashset.contains(sum)) return false;
            else hashset.add(sum);
            
            sum = digitSqure(sum);
            if(sum == 1) return true;
        }
    }
}