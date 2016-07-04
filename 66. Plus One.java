public class Solution{
    public int[] plusOne(Int[] digits){
        if(digits == null || digits.length == 0) return new int[];

        int n = digits.length;
        for(int i = n - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] sum = new int[n + 1];
        sum[0] = 1;
        return sum;
    }
}