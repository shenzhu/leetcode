public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return false;
        if(s.length() % 2 != 0) return false;
        
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case '(':
                    stack.push('(');
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }
}