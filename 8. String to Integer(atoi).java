public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        int i = 0, len = str.length();
        int num = 0, sign = 1, bound = Integer.MAX_VALUE / 10;
        
        // 1. Remove whitespaces
        while(i < len && str.charAt(i) == ' ') i++;
        
        // 2. Handle signs
        if(i < len && (str.charAt(i) == '+' || str.charAt(i) == '-')){
            sign = str.charAt(i++) == '-' ? -1 : 1;
        }
        
        // 3. Convert number
        while(i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            int digit = str.charAt(i++) - '0';
            boolean overflow = ((num == bound && digit >= 8) || num > bound);
            if(overflow) return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            num = num * 10 + digit;
        }
        
        return sign * num;
    }
}

public class Solution{
    public int myAtoi(String str){
        if(str == null || str.length() == 0) return 0;
        int i = 0, len = str.length();
        int total = 0, sign = 0, bound = Integer.MAX_VALUE / 10;

        // 1. Handle whitespaces
        while(str.charAt(i) == ' ' && i < len){
            i++;
        }

        // 2. Handle signs
        if(i < len && (str.charAt(i) == '-' || str.charAt(i) == '+')){
            sign = str.charAt(i) == '-'? -1 : 1;
        }

        while(i < len && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            int digit = str.charAt(i++) - '0';
            boolean overflow = (n == bound && digit >= 8) || (n > bound);
            if(overflow) return sign == -1? Integer.MIN_VALUE : Integer.MAX_VALUE;
            num = num * 10 + digit;
        }

        return sign * num;
    }
}